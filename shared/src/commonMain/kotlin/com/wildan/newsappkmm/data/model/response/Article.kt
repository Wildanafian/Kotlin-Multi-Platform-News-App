package com.wildan.newsappkmm.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class Article(
    var author: String? = "",
    var content: String? = "",
    var description: String? = "",
    var publishedAt: String? = "",
    var title: String? = "",
    var url: String? = "",
    var urlToImage: String? = ""
)