package com.cblue.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class StartService01 extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String name =  intent.getStringExtra("name");
        Log.i("aaa","name="+name);
        //执行后台的耗时操作
        Log.i("aaa","耗时操作");
        return super.onStartCommand(intent, flags, startId);
    }
}
