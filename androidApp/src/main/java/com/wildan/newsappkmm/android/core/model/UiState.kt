package com.wildan.newsappkmm.android.core.model


/*
 * Created by Wildan Nafian on 10/20/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

data class UiState<out R>(
    val data: R? = null,
    val message: String? = null,
    val loading: Boolean? = false,
)
