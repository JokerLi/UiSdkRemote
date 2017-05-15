/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/li/Android-WorkSpaces/MiAdSdkAIDL/src/com/xiaomi/ad/i18n/internal/IMiImageLoadListener.aidl
 */
package com.xiaomi.ad.i18n.internal;
public interface IMiImageLoadListener extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.xiaomi.ad.i18n.internal.IMiImageLoadListener
{
private static final java.lang.String DESCRIPTOR = "com.xiaomi.ad.i18n.internal.IMiImageLoadListener";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.xiaomi.ad.i18n.internal.IMiImageLoadListener interface,
 * generating a proxy if needed.
 */
public static com.xiaomi.ad.i18n.internal.IMiImageLoadListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.xiaomi.ad.i18n.internal.IMiImageLoadListener))) {
return ((com.xiaomi.ad.i18n.internal.IMiImageLoadListener)iin);
}
return new com.xiaomi.ad.i18n.internal.IMiImageLoadListener.Stub.Proxy(obj);
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
case TRANSACTION_onImageLoadSuccess:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.graphics.Bitmap _arg1;
if ((0!=data.readInt())) {
_arg1 = android.graphics.Bitmap.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.onImageLoadSuccess(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onImageLoadFailed:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onImageLoadFailed(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.xiaomi.ad.i18n.internal.IMiImageLoadListener
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
@Override public void onImageLoadSuccess(java.lang.String url, android.graphics.Bitmap bitmap) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(url);
if ((bitmap!=null)) {
_data.writeInt(1);
bitmap.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onImageLoadSuccess, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onImageLoadFailed(java.lang.String url) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(url);
mRemote.transact(Stub.TRANSACTION_onImageLoadFailed, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_onImageLoadSuccess = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_onImageLoadFailed = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
public void onImageLoadSuccess(java.lang.String url, android.graphics.Bitmap bitmap) throws android.os.RemoteException;
public void onImageLoadFailed(java.lang.String url) throws android.os.RemoteException;
}
