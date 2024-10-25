package com.wildan.newsappkmm.di

import com.wildan.newsappkmm.data.repository.TechCrunchNewsRepository
import com.wildan.newsappkmm.data.repository.TechCrunchNewsRepositoryImpl
import org.koin.dsl.module


/*
 * Created by Wildan Nafian on 10/20/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

val repositoryProvider = module {
    single<TechCrunchNewsRepository> { TechCrunchNewsRepositoryImpl(get()) }
}