package com.morladim.mario.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.morladim.mario.db.item.ItemDao
import com.morladim.mario.db.item.ItemEntity
import com.morladim.mario.db.reference.ReferenceEntity
import com.morladim.mario.db.tag.TagEntity
import com.morladim.mario.db.tag.TagJoinOtherEntity

/**
 *
 * @Author 5k5k
 * @Date 2021/12/5
 */
//url https://www.jianshu.com/p/ce063e04d116
//fts4 https://www.sqlite.org/fts3.html
@Database(
    entities = [ItemEntity::class, TagEntity::class, TagJoinOtherEntity::class, ReferenceEntity::class],
    version = 1
)
//@Database(entities = arrayOf(ItemEntity::class), version = 1,exportSchema = false )
//https://developer.android.com/codelabs/android-room-with-a-view-kotlin?hl=zh-cn#5
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): ItemDao
}