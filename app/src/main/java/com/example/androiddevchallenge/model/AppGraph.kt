package com.example.androiddevchallenge.model

sealed class AppGraph(val route: String) {
    object PuppyList : AppGraph("puppy_list")
    object PuppyDetails : AppGraph("puppy_detail")
}
