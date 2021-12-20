package com.morladim.mario.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.morladim.mario.R
import com.morladim.mario.base.LogUtils
import com.morladim.mario.main.setting.SettingRepository
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * 程序使用单Activity多Fragment的结构
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var r: SettingRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LogUtils.trace("main process: " + android.os.Process.myTid())

        lifecycleScope.launch {
            r.incrementCounter()
            r.exampleCounterFlow.collect {
                    v -> LogUtils.trace("]]]]]]]]]]]]]]]]]]] "+v.toString())
            }
        }

    }
}