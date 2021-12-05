package com.morladim.mario.setting

import android.content.SharedPreferences
import javax.inject.Inject

class SettingRepository @Inject constructor() {

    @Inject
    lateinit var editor: SharedPreferences.Editor

    fun saveTitle(title: String) {
        editor.putString("title", title).apply()
    }
}