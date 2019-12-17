package com.stepyen.testdemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_scheme.*
import java.net.URI

/**
 * date：2019-12-17
 * author：stepyen
 * description：测试 url scheme 调用
 *
 * 配合 XLearn 使用
 */
class SchemeActivity : AppCompatActivity() {

    companion object{
        val TAG = "SchemeActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scheme)
        Log.d(TAG, "onCreate")
        output()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d(TAG, "onNewIntent")
        output()
    }

    private fun output() {
        intent?.run {
            data?.run {
                val sb = StringBuilder()
                    .append("获取到的信息如下：")
                    .append("uri:   ${data.toString()}\n")
                    .append("sheme: $scheme\n")
                    .append("authority: $authority\n")
                    .append("host: $host\n")
                    .append("port: $port\n")
                    .append("path: $path\n")
                    .append("query: $query\n")
                    .append("fragment: $fragment\n")
                    .toString()

                Log.d(TAG, sb)

                tv_info.text = sb
            }
        }
    }
}
