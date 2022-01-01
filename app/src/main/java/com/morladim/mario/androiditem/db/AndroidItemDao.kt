package com.morladim.mario.androiditem.db


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

/**
 *
 * @Author 5k5k
 * @Date 2021/12/5
 */
@Dao
interface AndroidItemDao {

    //为了支持协程加入suspend
    @Query("SELECT * FROM android_item ORDER BY id LIMIT (:limit) OFFSET (:offset) ")
    suspend fun getByPage(limit: Int, offset: Int): List<AndroidItemEntity>

    @Query("SELECT * FROM android_item")
    fun getAll(): List<AndroidItemEntity>

    @Query("SELECT * FROM android_item WHERE id IN (:ids)")
    fun loadAllByIds(ids: IntArray): List<AndroidItemEntity>

    @Query(
        "SELECT * FROM android_item WHERE name LIKE :name " +
                " LIMIT 1"
    )
    fun findByName(name: String): AndroidItemEntity

    @Insert
    fun insertAll(vararg items: AndroidItemEntity)

    @Delete
    fun delete(item: AndroidItemEntity)

}