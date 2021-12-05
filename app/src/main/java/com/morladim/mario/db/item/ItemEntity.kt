package com.morladim.mario.db.item


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 *
 * @Author 5k5k
 * @Date 2021/12/5
 */
@Entity(tableName = "item")
data class ItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "createAt") val createAt: Date,
    @ColumnInfo(name = "updateAt") val updateAt: Date,

    @ColumnInfo(name = "name") val name: String,
    /**
     * 使用场景，意义，优劣势
     */
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "order") val order: Int?,
    @ColumnInfo(name = "favorite") val favorite: Boolean = false,
    val level: Int
)