package com.alphabangkit.socialdistancing.util

import android.content.Context
import android.preference.PreferenceManager

class SharedPreferences(val context: Context) {
    companion object{
        private const val FIRST_LOGIN = "FIRST_LOGIN"
    }

    private val p = PreferenceManager.getDefaultSharedPreferences(context)
    var firstlogin = p.getBoolean(FIRST_LOGIN, false)
    set(value) = p.edit().putBoolean(FIRST_LOGIN,value).apply()
}