package com.morladim.mario.db

import androidx.room.Database
import androidx.room.RoomDatabase

//url https://www.jianshu.com/p/ce063e04d116

@Database(entities = arrayOf(ItemEntity::class), version = 1)
//@Database(entities = arrayOf(ItemEntity::class), version = 1,exportSchema = false )
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}