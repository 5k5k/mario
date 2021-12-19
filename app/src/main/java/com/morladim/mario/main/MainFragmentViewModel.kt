package com.morladim.mario.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.morladim.mario.main.menu.MenuConstants
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
class MainFragmentViewModel @Inject constructor(private val menuDatabaseRepository: MenuDatabaseRepository) :
    ViewModel() {

    val menuEntity = getFirstMenu()

    val menuInfo = Transformations.switchMap(menuEntity) {
        MutableLiveData(MenuConstants.menuMaps[it.id]!!)
    }

    /**
     * 从数据库中获取首页第一个标签应该显示的模块
     */
    private fun getFirstMenu(): LiveData<MenuEntity> {
        return menuDatabaseRepository.getFirstMenu()
    }

}