package com.stepyen.testdemo.activity.function.scheme

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.stepyen.common.utils.IntentLogUtil
import com.stepyen.testdemo.MainActivity
import com.stepyen.testdemo.R
import com.stepyen.testdemo.base.BaseLifePageActivity

/**
 * date：2019-12-17
 * author：stepyen
 * description：测试 url scheme 调用
 *
 * 配合 XLearn 使用
 */
class SchemeSingleTaskActivity : BaseLifePageActivity() {
    override var TAG = "SchemeSingleTaskActivityTAG"


    override fun initView() {

        addTextView("当前是 SchemeSingleTaskActivity")
        startActivity(Intent(this@SchemeSingleTaskActivity, MainActivity::class.java).apply {  })
        finish()
    }
}

