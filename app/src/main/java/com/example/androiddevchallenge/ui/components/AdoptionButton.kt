package com.example.androiddevchallenge.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun AdoptionButton(modifier: Modifier = Modifier) {
    // TODO: active state
    // TODO: Small inactive state
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun AdoptionButtonPreview() {
    MyTheme {
        AdoptionButton()
    }
}