package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun HeaderRow(title: String, modifier: Modifier = Modifier) {
    Surface(
        color = Color.Gray,
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)
    ) {
        Text(text = title)
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
private fun HeaderRowPreview() {
    MyTheme {
        HeaderRow("Test Header Title")
    }
}