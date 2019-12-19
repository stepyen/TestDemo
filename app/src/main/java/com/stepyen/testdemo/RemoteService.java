package com.stepyen.testdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.stepyen.testdemo.aidl.RemoteInterface;

/**
 * date：2019-12-18
 * author：stepyen
 * description：
 */
public class RemoteService extends Service {

    public RemoteService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private final RemoteInterface.Stub mBinder = new RemoteInterface.Stub() {
        @Override
        public void setString(String str) throws RemoteException {
        }

        @Override
        public String getString() throws RemoteException {
            return "成功调用远程服务";
        }
    };
}




