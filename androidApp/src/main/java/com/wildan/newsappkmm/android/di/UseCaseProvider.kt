package com.wildan.newsappkmm.android.di

import com.wildan.newsappkmm.android.domain.LocalUseCase
import com.wildan.newsappkmm.android.domain.LocalUseCaseImpl
import com.wildan.newsappkmm.android.domain.TechCrunchNewsUseCase
import com.wildan.newsappkmm.android.domain.TechCrunchNewsUseCaseImpl
import org.koin.dsl.module


/*
 * Created by Wildan Nafian on 10/20/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

val useCaseProvider = module {
    single<LocalUseCase> { LocalUseCaseImpl() }
    single<TechCrunchNewsUseCase> { TechCrunchNewsUseCaseImpl(get()) }
}