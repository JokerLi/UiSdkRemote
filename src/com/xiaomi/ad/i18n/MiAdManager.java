package com.xiaomi.ad.i18n;

import android.content.Context;

import com.xiaomi.ad.i18n.internal.IMiImageListener;
import com.xiaomi.ad.i18n.internal.MiAdLoader;
import com.xiaomi.ad.i18n.internal.MiNativeAdInfo;

import java.util.Map;

/**
 * Created by root on 5/8/17.
 */

public class MiAdManager {
    public static final String PKG_NAME = "com.xiaomi.ad.i18n";

    private static MiAdManager sInstance;
    private Context mContext;
    private MiAdLoader mMiAdLoader;

    private MiAdManager(Context context) {
        mContext = context;
    }

    public static MiAdManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (MiAdManager.class) {
                if (sInstance == null) {
                    sInstance = new MiAdManager(context);
                }
            }
        }
        return sInstance;
    }

    public void loadNativeAd(long slotId, IMiAdManagerListener listener) {
        getAdLoader(mContext).loadAd(slotId, listener);
    }

    public void performClickAction(long slotId, MiNativeAdInfo info) {
        if (info == null) {
            return;
        }

        getAdLoader(mContext).actionClick(slotId, info.mAdId);
    }

    public void loadImage(String url, IMiImageListener listener) {
        getAdLoader(mContext).loadImage(url, listener);
    }

    public void reportData(Map<String, String> map) {
        getAdLoader(mContext).reportData(map);
    }

    private MiAdLoader getAdLoader(Context context) {
        if (mMiAdLoader == null) {
            mMiAdLoader = new MiAdLoader(context);
        }
        return mMiAdLoader;
    }

    public void destroy() {
        if (mMiAdLoader == null) {
            return;
        }
        mMiAdLoader.destroy();
        mMiAdLoader = null;
    }
}
