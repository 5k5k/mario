package com.morladim.mario.db.reference

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import java.util.*

/**
 *
 * @Author 5k5k
 * @Date 2021/12/5
 */
data class ReferenceEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val createAt: Date,
    val updateAt: Date,

    val url: String,
    val name: String?,
    @ColumnInfo(name = "item_id") val itemId: Int,
    val official: Boolean = false,
    val recommend: Boolean = false,
)
