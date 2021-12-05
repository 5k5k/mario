package com.morladim.mario.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.morladim.mario.db.item.ItemDao
import com.morladim.mario.db.item.ItemEntity

//url https://www.jianshu.com/p/ce063e04d116
//fts4 https://www.sqlite.org/fts3.html
@Database(entities = arrayOf(ItemEntity::class), version = 1)
//@Database(entities = arrayOf(ItemEntity::class), version = 1,exportSchema = false )
//https://developer.android.com/codelabs/android-room-with-a-view-kotlin?hl=zh-cn#5
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): ItemDao
}