package com.morladim.mario.main.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.morladim.mario.R

import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.preferencesDataStoreFile


class TestLauncherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_launcher)

//        val mJobScheduler = this.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
//
//        mJobScheduler.cancelAll();//取消应用所有的Job
////        val mBuilder = JobInfo.Builder(id, ComponentName(this, MyJobService::class.java))
////        mJobInfo = mBuilder.build()
//        val mServiceComponent = ComponentName(this, NetworkJobService::class.java)
////根据JobService创建一个ComponentName对象
////        mServiceComponent = ComponentName(this, NetworkJobService::class.java)
//        val builder = JobInfo.Builder(JobConstants.NETWORK_JOB_ID, mServiceComponent)
////        builder.setMinimumLatency(1000)
//
////        builder.setOverrideDeadline(2000) //设置该Job截至时间，在截至时间前肯定会执行该Job
//
////        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED) //设置所需网络类型
//
//        /**
//         * 设置为true设备为活动状态不执行
//         */
////        builder.setRequiresDeviceIdle(true) //设置在DeviceIdle时执行Job
//
//        builder.setRequiresCharging(true) //设置在充电时执行Job
////        builder.setPeriodic(AlarmManager.INTERVAL_FIFTEEN_MINUTES) //循环执行，循环时长为一天（最小为15分钟）
//
////        builder.setRequiresDeviceIdle(false)// 设备处于Idle(Doze)
////        builder.setPersisted(true) //设备重启后是否继续执行
////        builder.setBackoffCriteria(setBackoffCriteria3000， JobInfo . BACKOFF_POLICY_LINEAR) //设置退避/重试策略
//
//        // builder.setExtras(extras) //设置一个额外的附加项
//
//        mJobScheduler.schedule(builder.build());//调度Job
//        Toast.makeText(this, "ggg", Toast.LENGTH_SHORT).show()

//        val constraints = Constraints.Builder().setRequiresCharging(true).build()
//        val uploadWorkerRequest: WorkRequest =
//            OneTimeWorkRequestBuilder<UploadWorker>().setConstraints(constraints).addTag("tt1")
//                .build()
//        val id = uploadWorkerRequest.id
//        WorkManager.getInstance(application).enqueue(uploadWorkerRequest)
//        WorkManager.getInstance(application).getWorkInfoByIdLiveData(id).observe(this, object :
//            Observer<WorkInfo> {
//            override fun onChanged(t: WorkInfo?) {
//                println("change")
//
//                t?.state
//            }
//
//        })
    }
}