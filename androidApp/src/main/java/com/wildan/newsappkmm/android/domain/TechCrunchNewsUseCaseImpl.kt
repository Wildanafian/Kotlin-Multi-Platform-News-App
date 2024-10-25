package com.wildan.newsappkmm.android.domain

import com.wildan.newsappkmm.data.model.ui.NewsItem
import com.wildan.newsappkmm.data.model.wrapper.RemoteResult
import com.wildan.newsappkmm.data.repository.TechCrunchNewsRepository
import kotlinx.coroutines.flow.Flow

/*
 * Created by Wildan Nafian on 10/23/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

class TechCrunchNewsUseCaseImpl(
    private val repository: TechCrunchNewsRepository,
) : TechCrunchNewsUseCase {
    override fun getLatestNews(): Flow<RemoteResult<List<NewsItem>>> {
        return repository.getLatestTechNews()
    }
}
