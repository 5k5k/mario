package com.morladim.mario.main.menu.db

import androidx.lifecycle.LiveData
import com.morladim.mario.main.db.AppDatabase
import com.morladim.mario.main.factory.DatabaseRepository
import java.util.concurrent.Executor
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MenuDatabaseRepository @Inject constructor() {

    @Inject
    lateinit var menu: MenuDao

    @Inject
    lateinit var db: AppDatabase

    @DatabaseRepository.DbExecutor
    @Inject
    lateinit var executor: Executor

    fun getFirstMenu(): LiveData<MenuEntity> {
        return menu.getFirstMenu()
    }

    suspend fun getOthers(): List<MenuEntity> {
        return menu.getOthers()
    }

    fun getOtherMenuList():LiveData<List<MenuEntity>>{
        return menu.getOtherMenuList()
    }

//    suspend fun getOthersWithLiveData(): LiveData<List<MenuEntity>> {
//        return menu.getOthersWithLiveData()
//    }

    fun setAndroid0() {
        executor.execute {
            db.runInTransaction {
                menu.updateFirstById(1, 3)
                menu.updateFirstById(0, 1)
            }
        }
    }

    fun setAndroid1() {
        executor.execute {
            db.runInTransaction {
                menu.updateFirstById(1, 1)
                menu.updateFirstById(0, 3)
            }
        }
    }
}