package com.stepyen.testdemo.utils;

import android.os.Build;

/**
 * date：2020-03-17
 * author：stepyen
 * description：
 */
public class ApkUtil {

    /**
     * 是否需要服务在后台开启
     */
    public static boolean needMakeServiceForeground() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.O;
    }


}
