package com.wildan.newsappkmm.android.feature.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.SubcomposeAsyncImage
import com.wildan.newsappkmm.android.core.theme.Dimens.paddingNormal
import com.wildan.newsappkmm.android.core.theme.Dimens.spaceNormal
import com.wildan.newsappkmm.android.core.theme.TextTypography
import com.wildan.newsappkmm.android.feature.component.CircularLoading
import com.wildan.newsappkmm.android.feature.component.ImageLoadingError
import com.wildan.newsappkmm.android.feature.component.Toolbar
import com.wildan.newsappkmm.data.model.ui.NewsItem


/*
 * Created by Wildan Nafian on 9/16/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

@Composable
fun DetailScreen(navController: NavController, newsData: NewsItem?) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Toolbar(navController, "Detail", true)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            SubcomposeAsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                contentScale = ContentScale.Crop,
                model = newsData?.imgUrl,
                loading = {
                    CircularLoading()
                },
                error = {
                    ImageLoadingError()
                },
                alignment = Alignment.Center,
                contentDescription = "News Image"
            )

            Spacer(modifier = Modifier.height(spaceNormal))

            Text(
                modifier = Modifier.padding(start = paddingNormal, end = paddingNormal),
                text = newsData?.title.orEmpty(),
                style = TextTypography.titleLarge
            )

            Spacer(modifier = Modifier.height(spaceNormal))

            Text(
                modifier = Modifier.padding(start = paddingNormal, end = paddingNormal),
                text = newsData?.content.orEmpty() + newsData?.content.orEmpty(),
                style = TextTypography.bodyMedium,
            )

        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    DetailScreen(
        navController = rememberNavController(), newsData = NewsItem(
            title = "Bye-bye bots: Altera's game-playing AI agents get backing from Eric Schmidt | TechCrunch",
            content = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            date = "Terah",
            imgUrl = "Deloris",
            isBookmark = true,
        )
    )
}