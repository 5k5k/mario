package com.morladim.mario.db.tag

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 *
 * @Author 5k5k
 * @Date 2021/12/5
 */
@Entity(tableName = "tag_join_item")
data class TagJoinOtherEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val createAt: Date,
    val updateAt: Date,

    @ColumnInfo(name = "tag_id") val tagId: Int,
    @ColumnInfo(name = "other_id") val otherId: Int,
    /**
     * otherId的类型，0为AndroidItemEntity
     */
    val type: Int,
)