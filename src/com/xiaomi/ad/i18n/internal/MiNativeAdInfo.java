package com.xiaomi.ad.i18n.internal;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by root on 5/8/17.
 */

public class MiNativeAdInfo implements Parcelable {
    public String mTitle;
    public String mDescription;
    public String mCallToAction;
    public String mIconUrl;
    public String mImageUrl;
    public long mAdId;

    protected MiNativeAdInfo(Parcel in) {
        mTitle = in.readString();
        mDescription = in.readString();
        mCallToAction = in.readString();
        mIconUrl = in.readString();
        mImageUrl = in.readString();
        mAdId = in.readLong();
    }

    public MiNativeAdInfo() {
    }

    public static final Creator<MiNativeAdInfo> CREATOR = new Creator<MiNativeAdInfo>() {
        @Override
        public MiNativeAdInfo createFromParcel(Parcel in) {
            return new MiNativeAdInfo(in);
        }

        @Override
        public MiNativeAdInfo[] newArray(int size) {
            return new MiNativeAdInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mDescription);
        dest.writeString(mCallToAction);
        dest.writeString(mIconUrl);
        dest.writeString(mImageUrl);
        dest.writeLong(mAdId);
    }
}
