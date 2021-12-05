package com.morladim.mario.db.item


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item")
data class ItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "order") val order: Int?
)