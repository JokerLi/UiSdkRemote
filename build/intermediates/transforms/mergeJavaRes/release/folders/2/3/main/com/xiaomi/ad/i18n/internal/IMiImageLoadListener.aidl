package com.xiaomi.ad.i18n.internal;

import android.graphics.Bitmap;
interface IMiImageLoadListener {
    void onImageLoadSuccess(String url, in Bitmap bitmap);
    void onImageLoadFailed(String url);
}
