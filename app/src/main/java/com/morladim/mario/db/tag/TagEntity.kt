package com.morladim.mario.db.tag

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 *
 * @Author 5k5k
 * @Date 2021/12/5
 */
@Entity(tableName = "tag")
data class TagEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val createAt: Date,
    val updateAt: Date,

    val name: String,
)