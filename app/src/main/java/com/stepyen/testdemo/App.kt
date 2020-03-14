package com.stepyen.testdemo

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

/**
 * date：2020-03-14
 * author：stepyen
 * description：
 *
 */
class App :Application() {

    override fun onCreate() {
        super.onCreate()


        initLog()

    }

    /**
     * 初始化日志
     */
    private fun initLog() {

        val formatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(true) //(optional) whether to show thread info or not. Default true
            .methodCount(100) //(optional) how many method line to show, default 2。 显示多少个方法数
            .methodOffset(0) //(optional) hides internal method calls up to offset, default 5。从哪里开始显示的偏移量，为0的时候，就显示内部方法
            .tag("TestDemoTag") //(optional) global tag for every log, default PRETTY_LOGGER
            .build()
        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))

    }
}