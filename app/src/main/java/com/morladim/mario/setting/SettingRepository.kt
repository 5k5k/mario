package com.morladim.mario.setting

import android.content.SharedPreferences
import javax.inject.Inject
/**
 *
 * @Author 5k5k
 * @Date 2021/12/5
 */
class SettingRepository @Inject constructor() {

    @Inject
    lateinit var editor: SharedPreferences.Editor

    fun saveTitle(title: String) {
        editor.putString("title", title).apply()
    }
}