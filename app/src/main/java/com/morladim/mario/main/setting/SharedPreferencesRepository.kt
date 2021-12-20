package com.morladim.mario.main.setting

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 *
 * @Author 5k5k
 * @Date 2021/12/5
 */
@Module
@InstallIn(SingletonComponent::class)
@Deprecated("用DataStore替代")
class SharedPreferencesRepository {

    private val defaultSharedPreferencesName = "default"

    @Singleton
    @Provides
    fun getSharedPreferences(@ApplicationContext context: Context): SharedPreferences.Editor {
        return context.getSharedPreferences(defaultSharedPreferencesName, Context.MODE_PRIVATE)
            .edit()
    }
}