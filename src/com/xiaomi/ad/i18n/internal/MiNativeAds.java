package com.xiaomi.ad.i18n.internal;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 5/8/17.
 */

public class MiNativeAds implements Parcelable {
    public List<MiNativeAdInfo> mAdsInfoList = new ArrayList<MiNativeAdInfo>();
    public int mPlateId;

    public MiNativeAds() {
    }

    protected MiNativeAds(Parcel in) {
        in.readTypedList(mAdsInfoList, MiNativeAdInfo.CREATOR);
        mPlateId = in.readInt();
    }

    public static final Creator<MiNativeAds> CREATOR = new Creator<MiNativeAds>() {
        @Override
        public MiNativeAds createFromParcel(Parcel in) {
            return new MiNativeAds(in);
        }

        @Override
        public MiNativeAds[] newArray(int size) {
            return new MiNativeAds[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(mAdsInfoList);
        dest.writeInt(mPlateId);
    }
}
