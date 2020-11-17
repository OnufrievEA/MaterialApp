package com.example.materialapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    companion object {
        const val ThemePreference = "THEME"
        const val IsMainTheme = "IS_MAIN_THEME"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        when {
            isMainTheme() -> setTheme(R.style.BlueTheme)
            else -> setTheme(R.style.OrangeTheme)
        }
    }

    // Чтение настроек, параметр тема
    private fun isMainTheme(): Boolean {
        // Работаем через специальный класс сохранения и чтения настроек
        val sharedPref = getSharedPreferences(ThemePreference, MODE_PRIVATE)
        //Прочитать тему, если настройка не найдена - взять по умолчанию true
        return sharedPref.getBoolean(IsMainTheme, true)
    }

    // Сохранение настроек
    protected fun setMainTheme(isMainTheme: Boolean) {
        val sharedPref = getSharedPreferences(ThemePreference, MODE_PRIVATE)
        // Настройки сохраняются посредством специального класса editor.
        val editor = sharedPref.edit()
        editor.putBoolean(IsMainTheme, isMainTheme)
        editor.apply()
    }
}