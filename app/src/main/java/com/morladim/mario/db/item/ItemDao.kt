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
interface ItemDao {

    @Query("SELECT * FROM item")
    fun getAll(): List<ItemEntity>

    @Query("SELECT * FROM item WHERE id IN (:ids)")
    fun loadAllByIds(ids: IntArray): List<ItemEntity>

    @Query(
        "SELECT * FROM item WHERE name LIKE :name " +
                " LIMIT 1"
    )
    fun findByName(name: String): ItemEntity

    @Insert
    fun insertAll(vararg items: ItemEntity)

    @Delete
    fun delete(item: ItemEntity)

}