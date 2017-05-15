package com.xiaomi.ad.i18n.internal;

import com.xiaomi.ad.i18n.internal.IMiAdLoaderListener;
import com.xiaomi.ad.i18n.internal.IMiImageLoadListener;

interface IMiAdService {
    void loadNativeAdRemote(long slotId, IMiAdLoaderListener response);
    void loadImage(String url, IMiImageLoadListener listener);
    void triggerAdClickAction(long slotId, long adId);
    void reportData(in Map data);
}