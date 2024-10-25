package com.wildan.newsappkmm.android.feature.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.SubcomposeAsyncImage
import com.wildan.newsappkmm.android.R
import com.wildan.newsappkmm.android.core.theme.Dimens.elevation6
import com.wildan.newsappkmm.android.core.theme.Dimens.paddingNormal
import com.wildan.newsappkmm.android.core.theme.Dimens.paddingXSmall
import com.wildan.newsappkmm.android.core.theme.Dimens.radius12
import com.wildan.newsappkmm.android.core.theme.Dimens.size100
import com.wildan.newsappkmm.android.core.theme.Dimens.size150
import com.wildan.newsappkmm.android.core.theme.TextTypography
import com.wildan.newsappkmm.android.core.theme.gray
import com.wildan.newsappkmm.data.model.ui.NewsItem


/*
 * Created by Wildan Nafian on 10/20/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemNewsView(data: NewsItem, onTap: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(radius12),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = elevation6
        ),
        onClick = {
            onTap()
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(size150)
        ) {
            SubcomposeAsyncImage(
                modifier = Modifier
                    .width(size100)
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop,
                model = data.imgUrl,
                loading = {
                    CircularLoading()
                },
                error = {
                    ImageLoadingError()
                },
                alignment = Alignment.Center,
                contentDescription = "News Image"
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = paddingNormal,
                        top = paddingNormal,
                        bottom = paddingNormal,
                        end = paddingXSmall
                    )
                    .weight(1f)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    style = TextTypography.titleMedium,
                    text = data.title
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = paddingXSmall),
                    style = TextTypography.bodySmall,
                    text = data.content,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    color = gray
                )
            }

            Image(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(end = paddingXSmall),
                painter = painterResource(id = R.drawable.ic_bookmark),
                contentDescription = "Bookmark button",
                alignment = Alignment.Center,
            )
        }
    }
}

@Preview
@Composable
fun PreviewItemNewsView() {
    ItemNewsView(
        NewsItem(
            title = "Bye-bye bots: Altera's game-playing AI agents get backing from Eric Schmidt | TechCrunch",
            content = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            date = "Terah",
            imgUrl = "Deloris",
            isBookmark = true,
        )
    ) {}
}