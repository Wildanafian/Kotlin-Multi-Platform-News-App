package com.wildan.newsappkmm.android

import android.app.Application
import com.wildan.newsappkmm.android.di.moduleProvider
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/*
 * Created by Wildan Nafian on 10/20/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApp)
            modules(moduleProvider)
        }
    }
}