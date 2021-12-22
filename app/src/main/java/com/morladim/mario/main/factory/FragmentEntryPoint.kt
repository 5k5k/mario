package com.morladim.mario.main.factory

import com.morladim.mario.main.menu.db.MenuDatabaseRepository
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

/**
 *
 * @Author fireman
 * @Date 2021/12/18
 */
@EntryPoint
@InstallIn(FragmentComponent::class)
interface FragmentEntryPoint {

    fun getMenuDatabaseRepository(): MenuDatabaseRepository
}