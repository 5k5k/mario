package com.morladim.mario.setting

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SharedPreferencesRepository {

    private val defaultSharedPreferencesName = "default"

    @Singleton
    @Provides
    fun getSharedPreferences(@ApplicationContext context: Context): SharedPreferences.Editor {
        return context.getSharedPreferences(defaultSharedPreferencesName, Context.MODE_PRIVATE)
            .edit()
    }
}