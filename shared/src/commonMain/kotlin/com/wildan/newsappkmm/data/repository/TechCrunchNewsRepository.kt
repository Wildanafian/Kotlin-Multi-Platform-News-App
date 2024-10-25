package com.wildan.newsappkmm.data.repository

import com.wildan.newsappkmm.data.model.ui.NewsItem
import com.wildan.newsappkmm.data.model.wrapper.RemoteResult
import kotlinx.coroutines.flow.Flow


/*
 * Created by Wildan Nafian on 10/20/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

interface TechCrunchNewsRepository {
    fun getLatestTechNews(): Flow<RemoteResult<List<NewsItem>>>
}