package com.stepyen.testdemo.activity.function.scheme

import android.content.Intent
import com.stepyen.testdemo.MainActivity
import com.stepyen.testdemo.base.BaseLifePageActivity

/**
 * date：2019-12-17
 * author：stepyen
 * description：测试 url scheme 调用
 *
 * 配合 XLearn 使用
 */
class SchemeActivity : BaseLifePageActivity() {
    override var TAG = "SchemeActivityTAG"


    override fun initView() {

        addTextView("当前是 SchemeActivity")

        startActivity(Intent(this@SchemeActivity, MainActivity::class.java).apply {  })
        finish()
    }
}

