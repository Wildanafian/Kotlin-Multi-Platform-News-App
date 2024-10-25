package com.wildan.newsappkmm.android.di

import com.wildan.newsappkmm.android.feature.viewmodel.NewsViewModel
import org.koin.dsl.module


/*
 * Created by Wildan Nafian on 10/20/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

val viewModelProvider = module {
    single { NewsViewModel(get(), get()) }
}