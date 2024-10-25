package com.wildan.newsappkmm.android.domain

import android.content.Context
import com.wildan.newsappkmm.core.storage.SettingsFactory
import com.wildan.newsappkmm.data.model.ui.NewsItem
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/*
 * Created by Wildan Nafian on 10/23/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

class LocalUseCaseImpl : LocalUseCase, KoinComponent {

    private val context: Context by inject()
    private val localSource = SettingsFactory(context).createLocalSource()

    override fun cacheSomeGoodNews(data: List<NewsItem>) {
        localSource.putString(NEWS_DATA, Json.encodeToString(data))
    }

    override fun getSomeGoodNews(): List<NewsItem> {
        return Json.decodeFromString(localSource.getString(NEWS_DATA, defaultData()))
    }

    private fun defaultData(): String {
        return Json.encodeToString(emptyList<NewsItem>())
    }

    private companion object {
        const val NEWS_DATA = "news_data"
    }

}
