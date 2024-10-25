package com.wildan.newsappkmm.core.storage


/*
 * Created by Wildan Nafian on 10/22/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

interface KeyValueStorage {
    fun putString(key: String, value: String)
    fun getString(key: String, defaultValue: String): String
}

expect class SettingsFactory {
    fun createLocalSource(): KeyValueStorage
}

