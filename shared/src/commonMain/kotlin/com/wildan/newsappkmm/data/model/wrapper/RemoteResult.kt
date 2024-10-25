package com.wildan.newsappkmm.data.model.wrapper

sealed class RemoteResult<out T> {
    data class Success<T>(val data: T) : RemoteResult<T>()
    data class Error(val message: String) : RemoteResult<Nothing>()
}