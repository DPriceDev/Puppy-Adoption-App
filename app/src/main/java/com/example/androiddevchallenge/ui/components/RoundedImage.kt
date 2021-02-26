package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.transform.CircleCropTransformation
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun RoundedImage(url: String, modifier: Modifier = Modifier) {
    CoilImage(
        data = url,
        contentDescription = "Picture of Puppy",
        requestBuilder = {
            transformations(CircleCropTransformation())
        },
        loading = {
            Box(Modifier.matchParentSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        },
        modifier = modifier
    )
}

@Preview("Light Theme")
@Composable
private fun RoundedImagePreview() {
    MyTheme {
        RoundedImage(
            url = "abc",
            modifier = Modifier.size(48.dp)
        )
    }
}