package com.morladim.mario.main.menu

import androidx.lifecycle.ViewModel
import com.morladim.mario.main.menu.db.MenuDatabaseRepository
import com.morladim.mario.main.menu.db.MenuEntity
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