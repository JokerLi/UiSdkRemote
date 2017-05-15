/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/li/Android-WorkSpaces/MiAdSdkAIDL/src/com/xiaomi/ad/i18n/internal/IMiAdLoaderListener.aidl
 */
package com.xiaomi.ad.i18n.internal;
public interface IMiAdLoaderListener extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.xiaomi.ad.i18n.internal.IMiAdLoaderListener
{
private static final java.lang.String DESCRIPTOR = "com.xiaomi.ad.i18n.internal.IMiAdLoaderListener";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.xiaomi.ad.i18n.internal.IMiAdLoaderListener interface,
 * generating a proxy if needed.
 */
public static com.xiaomi.ad.i18n.internal.IMiAdLoaderListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.xiaomi.ad.i18n.internal.IMiAdLoaderListener))) {
return ((com.xiaomi.ad.i18n.internal.IMiAdLoaderListener)iin);
}
return new com.xiaomi.ad.i18n.internal.IMiAdLoaderListener.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onLoadSuccess:
{
data.enforceInterface(DESCRIPTOR);
com.xiaomi.ad.i18n.internal.MiNativeAds _arg0;
if ((0!=data.readInt())) {
_arg0 = com.xiaomi.ad.i18n.internal.MiNativeAds.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.onLoadSuccess(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onLoadFailed:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.onLoadFailed(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.xiaomi.ad.i18n.internal.IMiAdLoaderListener
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void onLoadSuccess(com.xiaomi.ad.i18n.internal.MiNativeAds ads) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((ads!=null)) {
_data.writeInt(1);
ads.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onLoadSuccess, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onLoadFailed(int errorCode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(errorCode);
mRemote.transact(Stub.TRANSACTION_onLoadFailed, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_onLoadSuccess = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_onLoadFailed = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
public void onLoadSuccess(com.xiaomi.ad.i18n.internal.MiNativeAds ads) throws android.os.RemoteException;
public void onLoadFailed(int errorCode) throws android.os.RemoteException;
}
