package com.morladim.mario.db.item

import com.morladim.mario.db.DatabaseRepository
import java.util.concurrent.Executor
import javax.inject.Inject
/**
 *
 * @Author 5k5k
 * @Date 2021/12/5
 */
class ItemDatabaseRepository @Inject constructor() {

    @Inject
    lateinit var item: ItemDao

    @DatabaseRepository.DbExecutor
    @Inject
    lateinit var executor: Executor

    fun insertAll(vararg items: ItemEntity) {
        executor.execute { item.insertAll(*items) }
    }
}