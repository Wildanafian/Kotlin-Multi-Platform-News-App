package com.wildan.newsappkmm.di

import com.wildan.newsappkmm.core.network.KtorClient
import com.wildan.newsappkmm.core.network.ktorEngine
import org.koin.dsl.module


/*
 * Created by Wildan Nafian on 10/20/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

val ktorProvider = module {
    single { ktorEngine() }
    single { KtorClient(get()).init() }
}