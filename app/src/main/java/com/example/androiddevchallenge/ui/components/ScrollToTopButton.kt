package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun ScrollToTopButton(modifier: Modifier = Modifier,
                      onClick: () -> Unit = { },
                      elevation: Dp = 8.dp,
                      size: Dp = 64.dp) {
    Surface(
        shape = CircleShape,
        elevation = elevation,
        modifier = Modifier
            .clickable { onClick() }
            .then(modifier)
    ) {
        Icon(
            imageVector = Icons.Default.KeyboardArrowUp,
            contentDescription = "Scroll To Top Button",
            modifier = Modifier
                .size(size)
                .padding(16.dp),
            tint = Color.Blue
        )
    }
}

@Preview("Light Theme", widthDp = 128, heightDp = 128)
@Composable
fun ScrollToTopButtonPreview() {
    MyTheme {
        ScrollToTopButton()
    }
}