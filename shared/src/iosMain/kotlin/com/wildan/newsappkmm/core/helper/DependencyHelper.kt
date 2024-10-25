package com.wildan.newsappkmm.core.helper

import com.wildan.newsappkmm.data.repository.TechCrunchNewsRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


/*
 * Created by Wildan Nafian on 10/20/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

class DependencyHelper : KoinComponent {
    val repository: TechCrunchNewsRepository by inject()
}