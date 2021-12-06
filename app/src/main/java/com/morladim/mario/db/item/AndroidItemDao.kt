package com.morladim.mario.db.item


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