package com.morladim.mario.menu

import androidx.lifecycle.ViewModel
import com.morladim.mario.db.menu.MenuDatabaseRepository
import com.morladim.mario.db.menu.MenuEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 *
 * @Author 5k5k
 * @Date 2021/12/17
 */
@HiltViewModel
class MenuItemViewModel @Inject constructor(private val menuDatabaseRepository: MenuDatabaseRepository) :
    ViewModel() {

//    suspend fun getMenuDataWithLiveData(): LiveData<List<MenuEntity>> {
//        return menuDatabaseRepository.getOthersWithLiveData()
//    }

    suspend fun getMenuData(): List<MenuEntity> {
        return menuDatabaseRepository.getOthers()
    }
}