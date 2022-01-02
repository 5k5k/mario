package com.morladim.mario.main.app

import android.app.Application
import android.os.StrictMode
import android.util.Log
import androidx.work.*
import com.morladim.mario.BuildConfig
import com.morladim.mario.sample.connect.UploadWorker
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application(), Configuration.Provider {

    override fun onCreate() {
        super.onCreate()
        val constraints = Constraints.Builder().setRequiresCharging(true).build()
        val uploadWorkerRequest: WorkRequest =
            OneTimeWorkRequestBuilder<UploadWorker>().setConstraints(constraints).addTag("tt1")
                .build()
        val id = uploadWorkerRequest.id
        WorkManager.getInstance(this).enqueue(uploadWorkerRequest)
//        WorkManager.getInstance(this).getWorkInfoByIdLiveData(id).observe(this, object :
//            Observer<WorkInfo> {
//            override fun onChanged(t: WorkInfo?) {
//                println("change")
//
//                t?.state
//            }
//
//        })
        //https://mp.weixin.qq.com/s?__biz=MzA5MzI3NjE2MA==&mid=2650251523&idx=1&sn=3409d80cc6c4252cbd4fb0e327eb3dcc&chksm=8863506cbf14d97aa6b640b6794395a158137e97b9db5804e2718b204affa3bb5c2aba8f6676&mpshare=1&scene=24&srcid=08259PAiFnKfqf8selFIZ3qD&sharer_sharetime=1598317827172&sharer_shareid=653d606fda642b58c9d033eeb6c60861#rd

        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .detectCustomSlowCalls()
//                    .penaltyDeath()
                    .build()
            )
            StrictMode.setVmPolicy(
                StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
//                    .penaltyDeath()
                    .build()
            )
        }
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setMinimumLoggingLevel(Log.INFO)
            .build()
    }
}