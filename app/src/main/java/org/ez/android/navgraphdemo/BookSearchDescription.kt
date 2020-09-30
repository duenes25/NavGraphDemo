package org.ez.android.navgraphdemo

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Text
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.ui.tooling.preview.Preview

/*
This is the main Widget.  What the Fragment will call
 */
@Composable
fun BookSearchDescription(onNavClick: () -> Unit) {
    bookSearchContent(onNavClick)
}

/*
This is the Content to display
 */
@Composable
private fun bookSearchContent(onNavClick: () -> Unit){
    searchButton(onNavClick)
}

@Composable
private fun searchButton(onNavClick: () -> Unit){
    Button(
        onClick = {
            onNavClick.invoke()
        },
        backgroundColor = Color.Red) {
        Text(text = stringResource(id = R.string.book_details ))
    }
}


@Preview
@Composable
private fun bookSearchContentPreview(onNavClick: () -> Unit){
    MaterialTheme {
        bookSearchContent(onNavClick)
    }
}