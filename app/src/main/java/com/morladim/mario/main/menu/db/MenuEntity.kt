package com.morladim.mario.main.menu.db

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 以id为key在代码中存储
 */
@Entity(tableName = "menu")
data class MenuEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var sort: Int,
    var first: Boolean = false,
)


//def paging_version = "3.1.0"
//
//implementation "androidx.paging:paging-runtime:$paging_version"
//
//// alternatively - without Android dependencies for tests
//testImplementation "androidx.paging:paging-common:$paging_version"