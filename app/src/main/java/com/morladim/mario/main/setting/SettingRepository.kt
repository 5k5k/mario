package com.morladim.mario.main.setting

import android.content.Context
import android.content.SharedPreferences
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

/**
 *
 * @Author 5k5k
 * @Date 2021/12/5
 */
@Singleton
class SettingRepository @Inject constructor(@ApplicationContext val context: Context) {

    val EXAMPLE_COUNTER = intPreferencesKey("example_counter")
    val exampleCounterFlow: Flow<Int> = context.dataStore.data
        .map { preferences ->
            // No type safety.
            preferences[EXAMPLE_COUNTER] ?: 0
        }

    suspend fun incrementCounter() {
        context.dataStore.edit { settings ->
            val currentCounterValue = settings[EXAMPLE_COUNTER] ?: 0
            settings[EXAMPLE_COUNTER] = currentCounterValue + 1
        }
    }


//    @Inject
//    lateinit var editor: SharedPreferences.Editor
//
//    fun saveTitle(title: String) {
//        editor.putString("title", title).apply()
//    }

//    val EXAMPLE_COUNTER = intPreferencesKey("example_counter")
//    val exampleCounterFlow: Flow<Int> =  dataStore.data
//        .map { preferences ->
//            // No type safety.
//            preferences[EXAMPLE_COUNTER] ?: 0
//        }

//    fun f(@ApplicationContext context: ApplicationContext):Flow<Int>{
//
//    }

}