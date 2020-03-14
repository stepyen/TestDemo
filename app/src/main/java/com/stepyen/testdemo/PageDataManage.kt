package com.stepyen.testdemo

import com.stepyen.testdemo.base.PageListActivity
import com.stepyen.testdemo.entity.PageBean
import com.stepyen.testdemo.activity.function.scheme.SchemeActivity
import com.stepyen.testdemo.activity.test.JavaTestActivity

/**
 * date：2020-02-12
 * author：stepyen
 * description：页面数据管理
 *
 */
object PageDataManage {
    val data: LinkedHashMap<PageBean, ArrayList<PageBean>> = LinkedHashMap<PageBean, ArrayList<PageBean>>()

    init {


        put("测试", arrayListOf<PageBean>().apply {

            add(PageBean("Java 测试", JavaTestActivity::class.java))

        })
        put("功能", arrayListOf<PageBean>().apply {

            add(PageBean("scheme", SchemeActivity::class.java))

        })







    }

    private fun put(title: String, list: ArrayList<PageBean>) {
        data[PageBean(title, PageListActivity::class.java)] = list
    }


}