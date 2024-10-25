package com.wildan.newsappkmm.di

import org.koin.core.context.startKoin


/*
 * Created by Wildan Nafian on 10/20/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

fun initKoin() {
    startKoin {
        modules(
            ktorProvider,
            remoteSource,
            repositoryProvider
        )
    }
}