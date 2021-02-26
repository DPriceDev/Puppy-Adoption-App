package com.example.androiddevchallenge.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun RotatingStar(modifier: Modifier = Modifier) {
    // todo: Create star
    // todo: set rotation speed
    // todo: set colour
    // todo: set scale animation?
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun RotatingStarPreview() {
    MyTheme {
        RotatingStar()
    }
}