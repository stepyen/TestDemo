package com.stepyen.testdemo

import android.content.ContentValues
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_content_provider.*

/**
 * date：2019-12-20
 * author：stepyen
 * description：学习 ContentProvider
 *
 * 获取 XLearn 项目中的 ContentProvider 的 Student 数据
 *
 */

class ContentProviderActivity : AppCompatActivity() {

    companion object {
        const val TAG = "ContentProviderActivity"

        var AUTHORITY = "com.stepyen.StudentContentProvider"

        val STUDENT_URI: Uri by lazy {
            Uri.parse("content://$AUTHORITY/student");
        }

        val handler: Handler by lazy {
            object : Handler() {
                override fun handleMessage(msg: Message) {
                    super.handleMessage(msg)
                    Log.i(TAG, msg.obj.toString())
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)


        val contentResolver = contentResolver;

        contentResolver.registerContentObserver(STUDENT_URI, true, StudentContentObserver(handler))


        btn_insert.setOnClickListener {

            contentResolver.insert(STUDENT_URI, ContentValues().apply {
                put("name", "stepyen")
                put("age", 99)
            })
        }

        btn_delete.setOnClickListener {
            contentResolver.delete(STUDENT_URI, null, null);
        }

        btn_update.setOnClickListener {

        }

        btn_query.setOnClickListener {

            contentResolver.query(STUDENT_URI, null, null, null, null, null)?.run {
                if (count > 0) {
                    while (moveToNext()) {
                        val name: String = getString(getColumnIndex("name"))
                        val age: Int = getInt(getColumnIndex("age"))
                        Log.i(TAG, "Student:name = $name,age = $age")
                    }
                    close()
                }
            }

        }


    }
}
