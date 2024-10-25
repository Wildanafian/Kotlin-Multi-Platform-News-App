package com.wildan.newsappkmm.di

import com.wildan.newsappkmm.data.datasource.remote.TechCrunchNewsRemote
import com.wildan.newsappkmm.data.datasource.remote.TechCrunchNewsRemoteImpl
import org.koin.dsl.module


/*
 * Created by Wildan Nafian on 10/20/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

val remoteSource = module {
    single<TechCrunchNewsRemote> { TechCrunchNewsRemoteImpl(get()) }
}