/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/li/Android-WorkSpaces/MiAdSdkAIDL/src/com/xiaomi/ad/i18n/internal/IMiAdService.aidl
 */
package com.xiaomi.ad.i18n.internal;
public interface IMiAdService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.xiaomi.ad.i18n.internal.IMiAdService
{
private static final java.lang.String DESCRIPTOR = "com.xiaomi.ad.i18n.internal.IMiAdService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.xiaomi.ad.i18n.internal.IMiAdService interface,
 * generating a proxy if needed.
 */
public static com.xiaomi.ad.i18n.internal.IMiAdService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.xiaomi.ad.i18n.internal.IMiAdService))) {
return ((com.xiaomi.ad.i18n.internal.IMiAdService)iin);
}
return new com.xiaomi.ad.i18n.internal.IMiAdService.Stub.Proxy(obj);
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
case TRANSACTION_loadNativeAdRemote:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
com.xiaomi.ad.i18n.internal.IMiAdLoaderListener _arg1;
_arg1 = com.xiaomi.ad.i18n.internal.IMiAdLoaderListener.Stub.asInterface(data.readStrongBinder());
this.loadNativeAdRemote(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_loadImage:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
com.xiaomi.ad.i18n.internal.IMiImageLoadListener _arg1;
_arg1 = com.xiaomi.ad.i18n.internal.IMiImageLoadListener.Stub.asInterface(data.readStrongBinder());
this.loadImage(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_triggerAdClickAction:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
long _arg1;
_arg1 = data.readLong();
this.triggerAdClickAction(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_reportData:
{
data.enforceInterface(DESCRIPTOR);
java.util.Map _arg0;
java.lang.ClassLoader cl = (java.lang.ClassLoader)this.getClass().getClassLoader();
_arg0 = data.readHashMap(cl);
this.reportData(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.xiaomi.ad.i18n.internal.IMiAdService
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
@Override public void loadNativeAdRemote(long slotId, com.xiaomi.ad.i18n.internal.IMiAdLoaderListener response) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(slotId);
_data.writeStrongBinder((((response!=null))?(response.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_loadNativeAdRemote, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void loadImage(java.lang.String url, com.xiaomi.ad.i18n.internal.IMiImageLoadListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(url);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_loadImage, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void triggerAdClickAction(long slotId, long adId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(slotId);
_data.writeLong(adId);
mRemote.transact(Stub.TRANSACTION_triggerAdClickAction, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void reportData(java.util.Map data) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeMap(data);
mRemote.transact(Stub.TRANSACTION_reportData, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_loadNativeAdRemote = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_loadImage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_triggerAdClickAction = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_reportData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
}
public void loadNativeAdRemote(long slotId, com.xiaomi.ad.i18n.internal.IMiAdLoaderListener response) throws android.os.RemoteException;
public void loadImage(java.lang.String url, com.xiaomi.ad.i18n.internal.IMiImageLoadListener listener) throws android.os.RemoteException;
public void triggerAdClickAction(long slotId, long adId) throws android.os.RemoteException;
public void reportData(java.util.Map data) throws android.os.RemoteException;
}
