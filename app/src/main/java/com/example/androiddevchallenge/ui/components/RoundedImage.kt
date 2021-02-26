package com.example.androiddevchallenge.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun RoundedImage(modifier: Modifier = Modifier) {
    // TODO: Setup image
    // todo: set rounded
    // todo: set loading spinner
    // todo: set loading error image
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun RoundedImagePreview() {
    MyTheme {
        RoundedImage()
    }
}