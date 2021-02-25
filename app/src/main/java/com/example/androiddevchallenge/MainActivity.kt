/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.detail.PuppyDetailUi
import com.example.androiddevchallenge.ui.list.PuppyListUi
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.viewmodel.PuppyListViewModel
import com.example.androiddevchallenge.viewmodel.PuppyListViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val puppyListViewModel: PuppyListViewModel by viewModels<PuppyListViewModelImpl>()

        setContent {
            MyTheme {
                MyApp(puppyListViewModel)
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(puppyListViewModel: PuppyListViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "puppy_list") {
        composable("puppy_list") {
            PuppyListUi.PuppyListLayout(puppyListViewModel) {
                navController.navigate("puppy_detail")
            }
        }
        composable("puppy_detail") {
            PuppyDetailUi.Layout()
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
//    val testViewModel = PuppyListViewModelImpl()
//    MyTheme {
//        MyApp(testViewModel)
//    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
//    val testViewModel = PuppyListViewModelImpl()
//    MyTheme(darkTheme = true) {
//        MyApp(testViewModel)
//    }
}
