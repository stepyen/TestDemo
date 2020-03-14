package com.stepyen.testdemo.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * date：2020-02-12
 * author：stepyen
 * description：
 *
 */
@Parcelize
class PageBean(val title:String,val cls:Class<*>): Parcelable {
}