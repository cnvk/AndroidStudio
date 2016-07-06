package com.cblue.broadcast;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by pavel on 2016/6/24.
 */
public class RemoteBroadcastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent();
        intent.setAction("notification");
        sendBroadcast(intent);
        Log.i("aaa","发送了notification广播");

    }
}
