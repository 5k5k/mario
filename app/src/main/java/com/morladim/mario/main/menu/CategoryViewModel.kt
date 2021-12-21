package com.morladim.mario.main.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.morladim.mario.main.menu.db.MenuDatabaseRepository
import com.morladim.mario.main.menu.db.MenuEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 *
 * @Author fireman
 * @Date 2021/12/21
 */
@HiltViewModel
class CategoryViewModel @Inject constructor(val menuDatabaseRepository: MenuDatabaseRepository) :
    ViewModel() {

    val menuList = findMenuList()

    val menuInfoList = Transformations.switchMap(menuList) {
        MutableLiveData(it.map { it1 ->
            MenuConstants.menuMaps[it1.id]!!
        })
    }

    fun findMenuList(): LiveData<List<MenuEntity>> {
        return menuDatabaseRepository.getOtherMenuList()
    }

}