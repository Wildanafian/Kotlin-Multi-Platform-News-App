package com.wildan.newsappkmm.data.repository

import com.wildan.newsappkmm.data.datasource.remote.TechCrunchNewsRemote
import com.wildan.newsappkmm.data.model.ui.NewsItem
import com.wildan.newsappkmm.data.model.wrapper.RemoteResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


/*
 * Created by Wildan Nafian on 10/20/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

class TechCrunchNewsRepositoryImpl(
    private val techCrunchNewsRemote: TechCrunchNewsRemote,
) : TechCrunchNewsRepository {

    override fun getLatestTechNews(): Flow<RemoteResult<List<NewsItem>>> {
        return flow {
            when (val result = techCrunchNewsRemote.getLatestNews()) {
                is RemoteResult.Success -> {
                    val mappedNews = result.data.map { data ->
                        NewsItem(
                            title = data.title.orEmpty(),
                            content = data.description.orEmpty(),
                            date = data.publishedAt.orEmpty(),
                            imgUrl = data.urlToImage.orEmpty(),
                            isBookmark = false
                        )
                    }

                    emit(RemoteResult.Success(data = mappedNews))
                }

                is RemoteResult.Error -> {
                    emit(result)
                }
            }
        }.flowOn(Dispatchers.IO)
    }

}