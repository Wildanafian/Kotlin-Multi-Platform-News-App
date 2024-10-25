package com.wildan.newsappkmm.android.di

import com.wildan.newsappkmm.di.ktorProvider
import com.wildan.newsappkmm.di.remoteSource
import com.wildan.newsappkmm.di.repositoryProvider


/*
 * Created by Wildan Nafian on 10/20/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

val moduleProvider = listOf(
    viewModelProvider,
    ktorProvider,
    remoteSource,
    repositoryProvider,
    useCaseProvider
)