package com.wildan.newsappkmm.android.feature.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController


/*
 * Created by Wildan Nafian on 9/16/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val startDestination = MainRoute.MAIN_GRAPH.name

    NavHost(navController = navController, startDestination = startDestination) {
        mainGraph(navController)
    }

}
