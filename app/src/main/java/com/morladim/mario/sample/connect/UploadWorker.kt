package com.morladim.mario.sample.connect

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class UploadWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {
    override fun doWork(): Result {
        println("doooo")
//        Toast.makeText(applicationContext, "123", Toast.LENGTH_SHORT).show()
        return Result.success()
    }
}