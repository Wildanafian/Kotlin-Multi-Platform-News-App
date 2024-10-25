package com.wildan.newsappkmm.android.feature.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wildan.newsappkmm.android.core.theme.gray


/*
 * Created by Wildan Nafian on 10/22/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

@Composable
fun CircularLoading() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.Center),
            color = gray
        )
    }
}