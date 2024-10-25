package com.wildan.newsappkmm.core.storage

import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import platform.Foundation.NSUserDefaults

/*
 * Created by Wildan Nafian on 10/22/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

class KeyValueStorageImpl : KeyValueStorage {

    private val userDefaults: Settings =
        NSUserDefaultsSettings(NSUserDefaults.standardUserDefaults())

    override fun putString(key: String, value: String) {
        userDefaults.putString(key, value)
    }

    override fun getString(key: String, defaultValue: String): String {
        return userDefaults.getString(key, "")
    }
}

actual class SettingsFactory {
    actual fun createLocalSource(): KeyValueStorage {
        return KeyValueStorageImpl()
    }
}
