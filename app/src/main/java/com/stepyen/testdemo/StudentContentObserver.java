package com.stepyen.testdemo;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;

/**
 * date：2019-12-20
 * author：stepyen
 * description：
 */
public class StudentContentObserver extends ContentObserver {

    Handler mHandler;
    public StudentContentObserver(Handler handler) {
        super(handler);
        mHandler = handler;
    }

    @Override
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);
    }

    @Override
    public void onChange(boolean selfChange, Uri uri) {
        super.onChange(selfChange, uri);
        Message message = Message.obtain();
        message.obj = uri;
        mHandler.sendMessage(message);
    }
}