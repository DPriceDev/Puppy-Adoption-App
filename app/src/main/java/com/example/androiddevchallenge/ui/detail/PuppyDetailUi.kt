package com.example.androiddevchallenge.ui.detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.viewmodel.detail.PuppyDetailViewModel

object PuppyDetailUi {
    
    @Composable
    fun Layout(puppyDetailViewModel: PuppyDetailViewModel) {
        Text(text = "Detail Layout")
    }
}