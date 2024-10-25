package com.wildan.newsappkmm.android.feature.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.wildan.newsappkmm.android.R


/*
 * Created by Wildan Nafian on 10/21/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

@Composable
fun AlertDialog(
    onDismissRequest: () -> Unit,
    dialogText: String,
) {
    AlertDialog(
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_warning),
                contentDescription = "Example Icon"
            )
        },
        title = {
            Text(text = "Ups something went wrong")
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {},
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}