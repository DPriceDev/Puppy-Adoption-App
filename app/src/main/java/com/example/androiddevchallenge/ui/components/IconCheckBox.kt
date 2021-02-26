package com.example.androiddevchallenge.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun IconCheckBox(modifier: Modifier = Modifier) {
    // TODO: active state shows a checkbox
    // TODO: Provide checkbox callback
    // TODO: Inactive shows icon
    // TODO: Animate between
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun IconCheckBoxPreview() {
    MyTheme {
        IconCheckBox()
    }
}