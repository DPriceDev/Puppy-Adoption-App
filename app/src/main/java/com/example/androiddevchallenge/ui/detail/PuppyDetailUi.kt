package com.example.androiddevchallenge.ui.detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.MyApp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.viewmodel.detail.PuppyDetailViewModel
import com.example.androiddevchallenge.viewmodel.detail.PuppyDetailViewModelImpl

object PuppyDetailUi {
    
    @Composable
    fun Layout(puppyDetailViewModel: PuppyDetailViewModel) {
        val puppy = puppyDetailViewModel.puppy

        // todo: Image of Dog
        // todo: Adopted Banner?
        // todo: Dog name
        Text(text = puppy.name)
        // todo: Dog Breed
        // todo: Description
        // todo: Dog Stats, floofiness?
        // todo: accept terms?
        // todo: adopt button
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
       // PuppyDetailUi.Layout()
    }
}