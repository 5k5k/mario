package com.morladim.mario.main.menu

import androidx.fragment.app.Fragment
import kotlin.reflect.KClass

/**
 *
 * @Author fireman
 * @Date 2021/12/18
 */
data class MenuInfo(val id: Int, val clazz: KClass<out Fragment>, val iconId: Int, val titleId: Int)
//可以以这种形式继承LiveData
//class MenuInfo(
//    id: Int, clazz: KClass<out Fragment>,
//    iconId: Int,
//    titleId: Int
//) :
//    LiveData<MenuInfo>() {
//
//    init {
//        postValue(this)
//    }
//
//    var id = id
//        set(v) {
//            field = v
//            postValue(this)
//        }
//    var clazz = clazz
//        set(v) {
//            field = v
//            postValue(this)
//        }
//
//    var iconId = iconId
//        set(v) {
//            field = v
//            postValue(this)
//        }
//
//    var titleId = titleId
//        set(v) {
//            field = v
//            postValue(this)
//        }
//
//}
