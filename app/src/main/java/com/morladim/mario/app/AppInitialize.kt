package com.morladim.mario.app

import android.app.Application
import android.content.Context
import androidx.startup.Initializer
import com.morladim.mario.base.LogUtils
import com.morladim.mario.db.DbManager

/**
 * 使用app startup做app初始化
 * dependencies在create前执行
 *
 * 遇到个问题，主进程没有activity的话，在manifest中的provider没有生效
 *
 * https://guolin.blog.csdn.net/article/details/108026357
 * https://www.jianshu.com/p/d752fb722920
 * @Author 5k5k
 * @Date 2021/11/13-20:15
 */
class AppInitialize : Initializer<Unit> {

    override fun create(context: Context) {
        //主线程
        LogUtils.init("===Nintendo##Mario##")
        LogUtils.trace("initialize process: " + android.os.Process.myTid())
//        DbManager.init(context.applicationContext as Application,"mario")
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}