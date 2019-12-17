package com.stepyen.testdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/**
 * date：2019-12-17
 * author：stepyen
 * description：跨进程通信
 *
 * 配合 XLearn 使用
 *
 */
class ProcessActivity: AppCompatActivity()  {
    companion object{
        val TAG = "ProcessActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_process)
        Log.d(TAG, "onCreate")

    }
}