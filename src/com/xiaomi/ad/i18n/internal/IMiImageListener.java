package com.xiaomi.ad.i18n.internal;

import android.graphics.Bitmap;

/**
 * Created by root on 5/10/17.
 */

public interface IMiImageListener {
    void onImageLoadSuccess(String url, Bitmap bitmap);

    void onImageLoadFailed(String url);
}
