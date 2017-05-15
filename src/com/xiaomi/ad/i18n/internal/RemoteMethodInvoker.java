package com.xiaomi.ad.i18n.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.xiaomi.ad.i18n.MiAdManager;
import com.xiaomi.ad.i18n.utils.CustomThreadUtils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class RemoteMethodInvoker<T> extends FutureTask<T> implements ServiceConnection {
    private static final String TAG = "MarketRemoteMethodInvoker";
    private final String MARKET_SERVICE_CLASS_NAME = "com.xiaomi.ad.i18n.service.NativeAdService";

    private T mResult = null;
    private Context mContext;
    private IMiAdService mMiAdService;
    private Object mLock = new Object();

    public interface InvokerListener {
        void invoke(IMiAdService s);
    }

    public RemoteMethodInvoker(Context context) {
        super(new Callable<T>() {
            @Override
            public T call() throws Exception {
                throw new IllegalStateException("this should never be called");
            }
        });
        mContext = context;
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        CustomThreadUtils.post(new Runnable() {
            @Override
            public void run() {
                Log.e("RemoteMethodInvoker", "onServiceDisconnected");
                synchronized (mLock) {
                    mMiAdService = null;
                }
                invokeAsync();
            }
        });
    }

    @Override
    public void onServiceConnected(ComponentName name, final IBinder service) {
        CustomThreadUtils.post(new Runnable() {
            @Override
            public void run() {
                // save IMiAdService Interface
                synchronized (mLock) {
                    mMiAdService = IMiAdService.Stub.asInterface(service);
                    Log.e("RemoteMethodInvoker", "onServiceConnected");
                    mLock.notifyAll();
                }
                mResult = null;
                set(mResult);
            }
        });
    }

    public void unbindService() {
        mContext.unbindService(RemoteMethodInvoker.this);
    }

    public void innerInvoke(final InvokerListener listener) throws RemoteException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (mLock) {
                    if (mMiAdService == null) {
                        try {
                            Log.e("RemoteMethodInvoker", "innerInvoke wait");
                            mLock.wait(10 * 1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Log.e("RemoteMethodInvoker", "innerInvoke");
                    listener.invoke(mMiAdService);
                }
                set(null);
            }
        }).start();
    }

    public T invoke() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(MiAdManager.PKG_NAME, MARKET_SERVICE_CLASS_NAME));
        if (mContext.bindService(intent, this, Context.BIND_AUTO_CREATE)) {
            try {
                return get();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            } catch (ExecutionException e) {
                return null;
            }
        } else {
        }
        return null;
    }

    public void invokeAsync() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(MiAdManager.PKG_NAME, MARKET_SERVICE_CLASS_NAME));
        mContext.bindService(intent, this, Context.BIND_AUTO_CREATE);
    }

    public void invokeInNewThread() {
        new Thread() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(MiAdManager.PKG_NAME, MARKET_SERVICE_CLASS_NAME));
                mContext.bindService(intent, RemoteMethodInvoker.this, Context.BIND_AUTO_CREATE);
            }
        }.start();
    }
}
