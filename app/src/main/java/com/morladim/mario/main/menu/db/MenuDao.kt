package com.morladim.mario.main.menu.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.morladim.mario.androiditem.db.AndroidItemEntity

@Dao
interface MenuDao {

//    @Query("SELECT * FROM menu WHERE first = 1  LIMIT 1")
//    fun findFirstMenu(): LiveData<MenuEntity>

    @Query("SELECT * FROM menu WHERE first = 1  LIMIT 1")
    fun getFirstMenu(): LiveData<MenuEntity>

    @Query("SELECT * FROM menu WHERE first = 0 ORDER BY sort ASC")
    suspend fun getOthers(): List<MenuEntity>

//    @Query("SELECT * FROM menu WHERE first = 0 ORDER BY sort ASC")
//    suspend fun getOthersWithLiveData(): LiveData<List<MenuEntity>>

    @Insert
    fun insertAll(vararg menus: MenuEntity)

    @Query("DELETE FROM menu")
    fun deleteAll()

    @Query("SELECT * FROM android_item WHERE id IN (:ids)")
    fun loadAllByIds(ids: IntArray): List<AndroidItemEntity>

    @Query("UPDATE menu SET first = 0 WHERE id = 1")
    fun updateAndroid0()

    @Query("UPDATE menu SET first = 1 WHERE id = 3")
    fun updateKotlin1()

    @Query("UPDATE menu SET first = :first WHERE id = :id")
    fun updateFirstById(first: Int, id: Int)
}