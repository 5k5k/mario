package com.morladim.mario.androiditem.db

import com.morladim.mario.main.factory.DatabaseRepository
import java.util.concurrent.Executor
import javax.inject.Inject
import javax.inject.Singleton

/**
 *
 * @Author 5k5k
 * @Date 2021/12/5
 */
@Singleton
class AndroidItemDatabaseRepository @Inject constructor() {

    @Inject
    lateinit var androidItem: AndroidItemDao

    @DatabaseRepository.DbExecutor
    @Inject
    lateinit var executor: Executor

    fun insertAll(vararg items: AndroidItemEntity) {
        executor.execute { androidItem.insertAll(*items) }
    }
}