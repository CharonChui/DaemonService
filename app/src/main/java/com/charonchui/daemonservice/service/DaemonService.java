package com.charonchui.daemonservice.service;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by Administrator on 2015/12/24.
 */
public class DaemonService extends Service{
    private static final String TAG = DaemonService.class.getSimpleName();

    @Override
    public void onCreate() {
        startDaemon(getPackageName() + DaemonService.class.getSimpleName(), Build.VERSION.SDK_INT);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "start service");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private native void startDaemon(String serviceName, int sdkVersion);

    static {
        System.loadLibrary("daemon");
    }
}
