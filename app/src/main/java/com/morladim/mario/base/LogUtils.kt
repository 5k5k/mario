package com.morladim.mario.base

import android.util.Log

/**
 * 日志工具类
 *
 * @Author 5k5k
 * @Date 2021/11/13-16:01
 */
object LogUtils {

    private lateinit var appTag: String

    /**
     * 初始化注入app的tag，应该区别于app的报名，属于逻辑上的tag
     */
    fun init(appTag: String) {
        this.appTag = appTag
    }

    fun trace(message: String) {
        checkInit()
        Log.d(appTag, message)
    }

    fun trace(message: String, tag: String) {
        checkInit()
        Log.d(appTag + tag, message)
    }

    private fun checkInit() {
//        if (appTag == null) {
//            throw RuntimeException("call LogUtils init first")
//        }
    }

    fun log(f: (tag: String?, message: String) -> Unit, tag: String?, message: String) {
        checkInit()
        f(appTag + tag, message)
    }
}