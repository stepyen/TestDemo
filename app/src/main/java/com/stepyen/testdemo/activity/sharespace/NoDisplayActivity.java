package com.stepyen.testdemo.activity.sharespace;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import com.orhanobut.logger.Logger;
import com.stepyen.testdemo.utils.ApkUtil;

/**
 * date：2020-03-17
 * author：stepyen
 * description：
 */
public class NoDisplayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            moveTaskToBack(true);//后台运行

            Logger.d("NoDisplayActivity onCreate");
            //启动后台服务
            Intent intent = new Intent();
            intent.setClass(this, ShareSpaceService.class);

            if (ApkUtil.needMakeServiceForeground()) {//必须要在前台
                startForegroundService(intent);
            } else {
                startService(intent);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        finish();
    }
}
