package com.xiaomi.ad.i18n.internal;

import com.xiaomi.ad.i18n.internal.MiNativeAds;
interface IMiAdLoaderListener {
    void onLoadSuccess(in MiNativeAds ads);
    void onLoadFailed(int errorCode);
}
