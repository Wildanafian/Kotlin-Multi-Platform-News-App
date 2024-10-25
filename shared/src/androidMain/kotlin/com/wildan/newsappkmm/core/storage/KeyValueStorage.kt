package com.wildan.newsappkmm.core.storage

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings


/*
 * Created by Wildan Nafian on 10/22/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

class KeyValueStorageImpl(context: Context) : KeyValueStorage {

    private val sharedPreferences: Settings =
        SharedPreferencesSettings(context.getSharedPreferences("YourName", MODE_PRIVATE))

    override fun putString(key: String, value: String) {
        sharedPreferences.putString(key, value)
    }

    override fun getString(key: String, defaultValue: String): String {
        return sharedPreferences.getString(key, defaultValue)
    }
}

actual class SettingsFactory(private val context: Context) {
    actual fun createLocalSource(): KeyValueStorage {
        return KeyValueStorageImpl(context)
    }
}
