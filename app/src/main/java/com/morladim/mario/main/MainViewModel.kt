package com.morladim.mario.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.morladim.mario.main.menu.db.MenuDatabaseRepository
import com.morladim.mario.main.menu.db.MenuEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 *
 * @Author fireman
 * @Date 2021/12/18
 */
@HiltViewModel
class MainViewModel @Inject constructor(private val menuDatabaseRepository: MenuDatabaseRepository) :
    ViewModel() {

//    suspend fun getFirstMenu(): MenuEntity {
//        return menuDatabaseRepository.getFirstMenu()
//    }

    suspend fun getFirstMenu(): LiveData<MenuEntity> {
        return menuDatabaseRepository.getFirstMenu()
    }
}