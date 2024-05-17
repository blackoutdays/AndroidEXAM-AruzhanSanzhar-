package com.example.lab10.ui.slideshow
import android.content.Context
import android.preference.PreferenceManager

object SharedPreferenceManager {
    private const val NIGHT_MODE_KEY = "night_mode"

    fun setNightModeEnabled(enabled: Boolean, context: Context) {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        sharedPreferences.edit().putBoolean(NIGHT_MODE_KEY, enabled).apply()
    }

    fun isNightModeEnabled(context: Context): Boolean {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        return sharedPreferences.getBoolean(NIGHT_MODE_KEY, false)
    }
}
