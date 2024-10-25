package com.wildan.newsappkmm.data.model.ui

import kotlinx.serialization.Serializable


/*
 * Created by Wildan Nafian on 9/30/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

@Serializable
data class NewsItem(
    var title: String,
    var content: String,
    var date: String,
    var imgUrl: String,
    var isBookmark: Boolean,
)
