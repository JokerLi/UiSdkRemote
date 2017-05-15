package com.xiaomi.ad.i18n.internal;

/**
 * Created by root on 5/8/17.
 */

public interface IMiNativeAdListener {
    void onSuccess(MiNativeAds ads);

    void onFailed(int errorCode);
}
