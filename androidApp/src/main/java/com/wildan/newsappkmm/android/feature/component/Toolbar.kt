package com.wildan.newsappkmm.android.feature.component

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import com.wildan.newsappkmm.android.R
import com.wildan.newsappkmm.android.core.theme.TextTypography


/*
 * Created by Wildan Nafian on 10/22/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(navController: NavController? = null, title: String, isBackButtonVisible: Boolean = false) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                style = TextTypography.titleLarge,
                text = title
            )
        },
        colors = topAppBarColors(
            containerColor = Color.White,
            titleContentColor = Color.Black
        ),
        navigationIcon = {
            if (isBackButtonVisible && navController != null) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_back),
                        contentDescription = "Back button",
                    )
                }
            }
        }
    )
}