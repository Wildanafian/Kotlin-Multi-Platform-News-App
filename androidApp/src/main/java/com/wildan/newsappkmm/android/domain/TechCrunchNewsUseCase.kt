package com.wildan.newsappkmm.android.domain

import com.wildan.newsappkmm.data.model.ui.NewsItem
import com.wildan.newsappkmm.data.model.wrapper.RemoteResult
import kotlinx.coroutines.flow.Flow


/*
 * Created by Wildan Nafian on 10/23/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

interface TechCrunchNewsUseCase {

    fun getLatestNews(): Flow<RemoteResult<List<NewsItem>>>

}
