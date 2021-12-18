package com.morladim.mario.androiditem.db


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 *
 * @Author 5k5k
 * @Date 2021/12/5
 */
@Entity(tableName = "android_item")
data class AndroidItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "create_at") val createAt: Date,
    @ColumnInfo(name = "update_at") val updateAt: Date,

    @ColumnInfo(name = "name") val name: String,
    /**
     * 使用场景，意义，优劣势
     */
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "order") val order: Long?,
    @ColumnInfo(name = "favorite") val favorite: Boolean = false,
    @ColumnInfo(name = "parent_id") val parentId: Long,
    /**
     * 重要程度，0 - 5
     */
    val important: Float
)