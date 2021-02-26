package com.example.androiddevchallenge.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun AdoptedStar(modifier: Modifier = Modifier) {
    // todo: Round image of dog
    // todo: Rotating star 1
    // todo: Rotating star 2
    // todo: adopted banner
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun AdoptedStarPreview() {
    MyTheme {
        AdoptedStar()
    }
}