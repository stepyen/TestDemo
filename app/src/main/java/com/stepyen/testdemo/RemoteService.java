package com.stepyen.testdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * date：2019-12-17
 * author：stepyen
 * description：
 */
public class RemoteService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
