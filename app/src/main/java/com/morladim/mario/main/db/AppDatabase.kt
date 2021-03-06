package com.morladim.mario.main.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.morladim.mario.androiditem.db.AndroidItemDao
import com.morladim.mario.androiditem.db.AndroidItemEntity
import com.morladim.mario.base.db.DbConverters
import com.morladim.mario.main.menu.db.MenuDao
import com.morladim.mario.main.menu.db.MenuEntity
import com.morladim.mario.base.db.reference.ReferenceEntity
import com.morladim.mario.base.db.tag.TagEntity
import com.morladim.mario.base.db.tag.TagJoinOtherEntity

/**
 *
 * @Author 5k5k
 * @Date 2021/12/5
 */
//url https://www.jianshu.com/p/ce063e04d116
//fts4 https://www.sqlite.org/fts3.html
@Database(
    entities = [AndroidItemEntity::class, TagEntity::class, TagJoinOtherEntity::class, ReferenceEntity::class, MenuEntity::class],
    version = 1
)
@TypeConverters(DbConverters::class)
//@Database(entities = arrayOf(ItemEntity::class), version = 1,exportSchema = false )
//https://developer.android.com/codelabs/android-room-with-a-view-kotlin?hl=zh-cn#5
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): AndroidItemDao

    abstract fun menuDao(): MenuDao

}