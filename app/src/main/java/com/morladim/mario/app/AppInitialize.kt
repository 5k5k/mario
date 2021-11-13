package com.morladim.mario.app

import android.content.Context
import androidx.startup.Initializer
import com.morladim.mario.base.LogUtils

/**
 * 使用app startup做app初始化
 * dependencies在create前执行
 *
 * 遇到个问题，主进程没有activity的话，在manifest中的provider没有生效
 *
 *
 *
 * https://guolin.blog.csdn.net/article/details/108026357
 * @Author 5k5k
 * @Date 2021/11/13-20:15
 */
class AppInitialize : Initializer<Unit> {
    override fun create(context: Context): Unit {
        LogUtils.init("===Nintendo##Mario##")
        LogUtils.trace("gogogo")
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}