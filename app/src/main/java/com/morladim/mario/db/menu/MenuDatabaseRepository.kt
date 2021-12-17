package com.morladim.mario.db.menu

import androidx.lifecycle.LiveData
import com.morladim.mario.db.DatabaseRepository
import java.util.concurrent.Executor
import javax.inject.Inject

class MenuDatabaseRepository @Inject constructor() {

    @Inject
    lateinit var menu: MenuDao

    @DatabaseRepository.DbExecutor
    @Inject
    lateinit var executor: Executor


    suspend fun getOthers(): List<MenuEntity> {
        return menu.getOthers()
    }

//    suspend fun getOthersWithLiveData(): LiveData<List<MenuEntity>> {
//        return menu.getOthersWithLiveData()
//    }

    fun getFirst(): LiveData<MenuEntity> {
        return menu.findFirstMenu()
    }
}