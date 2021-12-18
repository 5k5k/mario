package com.morladim.mario.base.db.reference

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 *
 * @Author 5k5k
 * @Date 2021/12/5
 */
@Entity(tableName = "reference")
data class ReferenceEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "create_at") val createAt: Date,
    @ColumnInfo(name = "update_at") val updateAt: Date,

    val url: String,
    val name: String?,
    @ColumnInfo(name = "item_id") val itemId: Long,
    val official: Boolean = false,
    val recommend: Boolean = false,
    /**
     * otherId的类型，0为AndroidItemEntity
     */
    val type: Int,
)
