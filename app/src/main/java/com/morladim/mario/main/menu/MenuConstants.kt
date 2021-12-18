package com.morladim.mario.main.menu

import androidx.fragment.app.Fragment
import com.morladim.mario.androiditem.AndroidFragment
import com.morladim.mario.kotlin.KotlinFragment
import kotlin.reflect.KClass

/**
 *
 * @Author fireman
 * @Date 2021/12/18
 */
object MenuConstants {

    val menuMaps = HashMap<Int, MenuInfo>()

    init {
        var current = 1

        var menuInfo = MenuInfo(current, clazz = AndroidFragment::class)
        menuMaps[current] = menuInfo

        menuInfo = MenuInfo(++current, clazz = AndroidFragment::class as KClass<Fragment>)
        menuMaps[current] = menuInfo
        //        val yang = MenuEntity(++current, "WanAndroid", current, false)


        menuInfo = MenuInfo(++current, clazz = KotlinFragment::class as KClass<Fragment>)
        menuMaps[current] = menuInfo


//        val androidStudio = MenuEntity(++current, "AS", current, false)
//        val leetCode = MenuEntity(++current, "LeetCode", current, false)
//        val git = MenuEntity(++current, "Git", current, false)
//        val shell = MenuEntity(++current, "Shell", current, false)
//        val architecture = MenuEntity(++current, "架构", current, false)
//        val vi = MenuEntity(++current, "Vi", current, false)
//        val sql = MenuEntity(++current, "Sql", current, false)
//        val regular = MenuEntity(++current, "正则", current, false)

    }
}