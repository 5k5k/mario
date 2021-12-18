package com.morladim.mario.sample.connect

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log
import android.widget.Toast

class NetworkJobService : JobService() {

    private val TAG = "TestService"

    /**
     * 返回false表示任务完成，onStopJob不会调用
     */
    override fun onStartJob(params: JobParameters?): Boolean {
        Log.e(TAG,"onStartJob starttt");
        println("job starttt")
        Toast.makeText(this.application, "start", Toast.LENGTH_LONG).show()
        jobFinished(params, true)
        return true
    }

    /**
     * true：下次还来
     * false：作业完全结束
     * 无论返回什么值作业都会结束
     */
    override fun onStopJob(params: JobParameters?): Boolean {
        println("job stop")
        Toast.makeText(this.application, "end", Toast.LENGTH_SHORT).show()
        return true
    }
}