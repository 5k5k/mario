package com.morladim.mario.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.morladim.mario.R
import com.morladim.mario.base.LogUtils
import dagger.hilt.android.AndroidEntryPoint

/**
 * 程序使用单Activity多Fragment的结构
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LogUtils.trace("main process: " + android.os.Process.myTid())
    }
}