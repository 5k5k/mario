package com.morladim.mario.main.menu

import androidx.fragment.app.Fragment
import kotlin.reflect.KClass

/**
 *
 * @Author fireman
 * @Date 2021/12/18
 */
data class MenuInfo(val id: Int, val clazz: KClass<out Fragment>)
