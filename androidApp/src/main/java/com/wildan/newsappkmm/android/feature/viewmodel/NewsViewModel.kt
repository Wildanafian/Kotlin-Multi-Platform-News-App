package com.wildan.newsappkmm.android.feature.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wildan.newsappkmm.android.core.model.UiState
import com.wildan.newsappkmm.android.domain.LocalUseCase
import com.wildan.newsappkmm.android.domain.TechCrunchNewsUseCase
import com.wildan.newsappkmm.data.model.ui.NewsItem
import com.wildan.newsappkmm.data.model.wrapper.RemoteResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


/*
 * Created by Wildan Nafian on 10/20/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

class NewsViewModel(
    private val newsUseCase: TechCrunchNewsUseCase,
    private val localUseCase: LocalUseCase,
) : ViewModel() {

    private val _news = MutableStateFlow<UiState<List<NewsItem>>>(UiState())
    val newsData: StateFlow<UiState<List<NewsItem>>> = _news.asStateFlow()

    fun getLatestNews() {
        viewModelScope.launch {
            newsUseCase.getLatestNews()
                .onStart {
                    _news.update {
                        it.copy(
                            data = localUseCase.getSomeGoodNews(),
                            loading = true
                        )
                    }
                }
                .collect { result ->
                    when (result) {
                        is RemoteResult.Success -> {
                            _news.update { it.copy(data = result.data, loading = false) }
                            localUseCase.cacheSomeGoodNews(result.data)
                        }

                        is RemoteResult.Error -> {
                            _news.update { it.copy(message = result.message, loading = false) }
                        }
                    }
                }
        }
    }

    fun closeDialog() {
        _news.update { it.copy(message = null, loading = false) }
    }

}
