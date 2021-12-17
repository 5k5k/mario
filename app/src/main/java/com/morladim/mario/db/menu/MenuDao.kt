package com.morladim.mario.db.menu

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MenuDao {

    @Query(
        "SELECT * FROM menu WHERE first = true " +
                " LIMIT 1"
    )
    fun findFirstMenu(): LiveData<MenuEntity>

    @Query("SELECT * FROM menu WHERE first = 0 ORDER BY sort ASC")
    suspend fun getOthers(): List<MenuEntity>

//    @Query("SELECT * FROM menu WHERE first = 0 ORDER BY sort ASC")
//    suspend fun getOthersWithLiveData(): LiveData<List<MenuEntity>>

    @Insert
    fun insertAll(vararg menus: MenuEntity)

    @Query("DELETE FROM menu")
    fun deleteAll()
}