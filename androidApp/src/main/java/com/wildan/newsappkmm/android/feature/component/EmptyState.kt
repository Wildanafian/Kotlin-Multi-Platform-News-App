package com.wildan.newsappkmm.android.feature.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.wildan.newsappkmm.android.R


/*
 * Created by Wildan Nafian on 10/22/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

@Composable
fun ImageLoadingError() {
    Image(
        modifier = Modifier
            .fillMaxSize(),
        painter = painterResource(id = R.drawable.img_error_state),
        contentDescription = "Cannot load image",
        contentScale = ContentScale.Crop
    )
}