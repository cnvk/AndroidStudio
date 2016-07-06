package com.cblue.androidstudio;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

/**
 * Created by pavel on 2016/6/23.
 */
public class MyService extends Service {


    Messenger messenger = new Messenger(new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //从服务端获得的消息，然后处理之后发送给客户端
            Message serverMessage =  Message.obtain(msg);
            Log.i("aaa","得到客户端的消息:"+serverMessage.arg1+"和"+serverMessage.arg2);
            serverMessage.arg1 = serverMessage.arg1 +serverMessage.arg2;
            try {
                serverMessage.replyTo.send(serverMessage);
            }catch (Exception e){

            }

        }
    });

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return messenger.getBinder();
    }
}
