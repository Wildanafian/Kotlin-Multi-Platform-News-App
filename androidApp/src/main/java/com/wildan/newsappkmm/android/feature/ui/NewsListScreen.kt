package com.wildan.newsappkmm.android.feature.ui

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.wildan.newsappkmm.android.core.theme.Dimens.paddingNormal
import com.wildan.newsappkmm.android.core.theme.Dimens.size60
import com.wildan.newsappkmm.android.feature.component.AlertDialog
import com.wildan.newsappkmm.android.feature.component.ItemNewsView
import com.wildan.newsappkmm.android.feature.component.Toolbar
import com.wildan.newsappkmm.android.feature.navigation.MainRoute
import com.wildan.newsappkmm.android.feature.viewmodel.NewsViewModel
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.androidx.compose.koinViewModel


/*
 * Created by Wildan Nafian on 10/20/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

@Composable
fun NewsListScreen(navController: NavController) {

    val vm: NewsViewModel = koinViewModel()
    val newsData by vm.newsData.collectAsState()

    LaunchedEffect(key1 = Unit) {
        vm.getLatestNews()
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Toolbar(title = "News App")
        },
        content = { innerPadding ->
            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White)
                        .padding(0.dp, innerPadding.calculateTopPadding(), 0.dp, 0.dp)
                ) {
                    LazyColumn(
                        contentPadding = PaddingValues(paddingNormal),
                        verticalArrangement = Arrangement.spacedBy(paddingNormal),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(newsData.data.orEmpty()) { item ->
                            ItemNewsView(data = item) {
                                val newsItem = Json.encodeToString(item)
                                navController.navigate(
                                    "${MainRoute.DETAIL.name}/${
                                        Uri.encode(
                                            newsItem
                                        )
                                    }"
                                )
                            }
                        }
                    }
                }

                if (newsData.loading == true) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .width(size60)
                            .height(size60)
                            .align(Alignment.Center)
                    )
                }

                if (!newsData.message.isNullOrEmpty()) {
                    AlertDialog(
                        onDismissRequest = {
                            vm.closeDialog()
                        },
                        dialogText = newsData.message.orEmpty()
                    )
                }
            }
        }
    )
}

@Preview
@Composable
fun PreviewNewsListScreen() {
    NewsListScreen(rememberNavController())
}