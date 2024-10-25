package com.wildan.newsappkmm.android.feature.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.wildan.newsappkmm.android.core.constant.GeneralConstant.DATA
import com.wildan.newsappkmm.android.feature.ui.DetailScreen
import com.wildan.newsappkmm.android.feature.ui.NewsListScreen
import com.wildan.newsappkmm.data.model.ui.NewsItem
import kotlinx.serialization.json.Json


/*
 * Created by Wildan Nafian on 9/16/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

fun NavGraphBuilder.mainGraph(navController: NavController) {
    navigation(startDestination = MainRoute.NEWS_LIST.name, route = MainRoute.MAIN_GRAPH.name) {
        composable(MainRoute.NEWS_LIST.name) { NewsListScreen(navController = navController) }
        composable(
            route = "${MainRoute.DETAIL.name}/{$DATA}",
            arguments = listOf(navArgument(DATA) { type = NavType.StringType })
        ) { backStackEntry ->
            val newsDetailJson = backStackEntry.arguments?.getString(DATA)
            val newsDetail = newsDetailJson?.let { Json.decodeFromString<NewsItem>(it) }
            DetailScreen(navController = navController, newsData = newsDetail)
        }
    }
}
