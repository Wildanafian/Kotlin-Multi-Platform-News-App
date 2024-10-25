package com.wildan.newsappkmm.android.domain

import com.wildan.newsappkmm.data.model.ui.NewsItem


/*
 * Created by Wildan Nafian on 10/23/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

interface LocalUseCase {
    fun cacheSomeGoodNews(data: List<NewsItem>)
    fun getSomeGoodNews(): List<NewsItem>
}
