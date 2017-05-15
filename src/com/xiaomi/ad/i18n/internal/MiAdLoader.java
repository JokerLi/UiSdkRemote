package com.xiaomi.ad.i18n.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.util.Log;

import java.util.Map;

/**
 * Created by root on 5/8/17.
 */

public class MiAdLoader {
    private Context mContext;
    private RemoteMethodInvoker<Void> mInvoker;

    public MiAdLoader(Context context) {
        mContext = context;
        mInvoker = new RemoteMethodInvoker<Void>(mContext);
        mInvoker.invokeAsync();
    }

    public void loadAd(final long slotId, final IMiNativeAdListener listener) {
        try {
            mInvoker.innerInvoke(new RemoteMethodInvoker.InvokerListener() {
                @Override
                public void invoke(IMiAdService s) {
                    try {
                        MyNativeAdLoaderListener loaderListener = new MyNativeAdLoaderListener(listener);
                        s.loadNativeAdRemote(slotId, loaderListener);
                    } catch (Exception error) {
                        Exception message = error;
                        String mess = message.getMessage();
                        Log.e("MiAdLoader", error.getMessage() + "");
                    }
                }
            });
        } catch (Exception e) {

        }
    }

    public void actionClick(final long slotId, final long adId) {
        try {
            mInvoker.innerInvoke(new RemoteMethodInvoker.InvokerListener() {
                @Override
                public void invoke(IMiAdService s) {
                    try {
                        s.triggerAdClickAction(slotId, adId);
                    } catch (Exception e) {
                    }
                }
            });
        } catch (Exception e) {

        }
    }

    public void loadImage(final String url, final IMiImageListener listener) {
        try {
            mInvoker.innerInvoke(new RemoteMethodInvoker.InvokerListener() {
                @Override
                public void invoke(IMiAdService s) {
                    try {
                        s.loadImage(url, new IMiImageLoadListener.Stub() {
                            public void onImageLoadSuccess(String url, Bitmap bitmap) {
                                if (listener != null) {
                                    listener.onImageLoadSuccess(url, bitmap);
                                }
                            }

                            public void onImageLoadFailed(String url) {
                                if (listener != null) {
                                    listener.onImageLoadFailed(url);
                                }
                            }
                        });
                    } catch (Exception e) {
                    }
                }
            });
        } catch (Exception e) {

        }
    }

    public void reportData(final Map<String, String> map) {
        try {
            mInvoker.innerInvoke(new RemoteMethodInvoker.InvokerListener() {
                @Override
                public void invoke(IMiAdService s) {
                    try {
                        s.reportData(map);
                    } catch (Exception e) {
                    }
                }
            });
        } catch (Exception e) {

        }
    }

    public void destroy() {
        mInvoker.unbindService();
    }

    private static class MyNativeAdLoaderListener extends IMiAdLoaderListener.Stub {
        private IMiNativeAdListener mListener;

        public MyNativeAdLoaderListener(IMiNativeAdListener listener) {
            mListener = listener;
        }

        @Override
        public void onLoadSuccess(MiNativeAds ads) {
            if (mListener != null) {
                mListener.onSuccess(ads);
            }
        }

        @Override
        public void onLoadFailed(int errorCode) {
            if (mListener != null) {
                mListener.onFailed(errorCode);
            }
        }
    }
}
