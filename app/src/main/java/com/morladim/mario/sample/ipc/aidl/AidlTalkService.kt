package com.morladim.mario.sample.ipc.aidl

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.morladim.mario.sample.ipc.ITalkAidlInterface
import com.morladim.mario.sample.ipc.ITalkCallbackAidlInterface
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class AidlTalkService : Service() {

    override fun onBind(intent: Intent): IBinder {

        val e = Executors.newSingleThreadScheduledExecutor()
        e.scheduleAtFixedRate({
            callbacks.forEach { c -> c.onMessage("sdf") }
        }, 0, 5, TimeUnit.SECONDS)

        return binder
    }

    private val callbacks = ArrayList<ITalkCallbackAidlInterface>()

    private val binder = object : ITalkAidlInterface.Stub() {
        override fun tellServer(s: String?) {
            println(s)
        }

        override fun getMessage(): String {
            return "gggg message"
        }

        override fun registerCallback(callback: ITalkCallbackAidlInterface?) {
            if (callback != null) {
                callbacks.add(callback)
            }
        }

        override fun unRegisterCallback(callback: ITalkCallbackAidlInterface?) {
            callbacks.remove(callback)
        }

    }
}