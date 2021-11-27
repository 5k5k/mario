package com.morladim.mario

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.morladim.mario.base.LogUtils
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LogUtils.trace("main process: " + android.os.Process.myTid())

        val handler = Handler(Looper.getMainLooper()) {

            if (it.what == 1) {
                Toast.makeText(this, "222", Toast.LENGTH_LONG).show()
            }
            return@Handler true
        }
        val e = Executors.newSingleThreadScheduledExecutor()
        e.scheduleAtFixedRate({
            try {
                LogUtils.trace("1111")
//                handler.post {
//                    Toast.makeText(this, "!111", Toast.LENGTH_LONG).show()
//                }
                handler.sendEmptyMessage(1)
                LogUtils.trace("222")
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }, 0, 5, TimeUnit.SECONDS)

    }


}