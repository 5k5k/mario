package com.morladim.mario.db

import android.app.Application
import androidx.room.Room

/**
 *
 * @Author 5k5k
 * @Date 2021/11/27-22:16
 */
object DbManager {
    private lateinit var dbName: String
    private lateinit var context: Application
    private var db: AppDatabase? = null

    fun init(context: Application, dbName: String, lateInit: Boolean = true) {
        this.context = context
        this.dbName = dbName
        if (!lateInit) {
            createDb()
        }
    }

    private fun createDb() {
        if (db == null) {
            db = Room.databaseBuilder(
                context,
                AppDatabase::class.java, dbName
            ).build()
        }
    }
}