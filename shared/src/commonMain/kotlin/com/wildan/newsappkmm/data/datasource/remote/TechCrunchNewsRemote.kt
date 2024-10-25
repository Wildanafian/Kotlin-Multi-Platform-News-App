package com.wildan.newsappkmm.data.datasource.remote

import com.wildan.newsappkmm.data.model.response.Article
import com.wildan.newsappkmm.data.model.wrapper.RemoteResult


/*
 * Created by Wildan Nafian on 10/20/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

interface TechCrunchNewsRemote {

    suspend fun getLatestNews(): RemoteResult<List<Article>>

}