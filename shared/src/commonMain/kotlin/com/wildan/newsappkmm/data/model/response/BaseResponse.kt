package com.wildan.newsappkmm.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    var articles: T? = null,
    var status: String = "",
    var message: String = "",
    var totalResults: Int = 0,
)