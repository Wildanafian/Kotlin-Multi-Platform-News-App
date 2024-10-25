package com.wildan.newsappkmm.core.helper

import com.wildan.newsappkmm.data.model.ui.NewsItem
import com.wildan.newsappkmm.data.model.wrapper.RemoteResult

fun <T> RemoteResult<T>.handleWithCare(
    onSuccess: (T) -> Unit,
    onError: (String) -> Unit
) {
    when (this) {
        is RemoteResult.Success -> onSuccess(this.data)
        is RemoteResult.Error -> onError(this.message)
    }
}

fun RemoteResult<List<NewsItem>>.handleData(
    onSuccess: (List<NewsItem>) -> Unit,
    onError: (String) -> Unit
) {
    when (this) {
        is RemoteResult.Success -> onSuccess(this.data)

        is RemoteResult.Error -> onError(this.message)
    }
}