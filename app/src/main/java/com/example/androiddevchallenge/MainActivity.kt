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
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SquareFoot
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.example.androiddevchallenge.model.AppGraph
import com.example.androiddevchallenge.ui.detail.PuppyDetailUi
import com.example.androiddevchallenge.ui.list.PuppyListUi
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.viewmodel.detail.PuppyDetailViewModel
import com.example.androiddevchallenge.viewmodel.detail.PuppyDetailViewModelImpl
import com.example.androiddevchallenge.viewmodel.list.PuppyListViewModel
import com.example.androiddevchallenge.viewmodel.list.PuppyListViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp(puppyDetailViewModel: PuppyDetailViewModel = viewModel<PuppyDetailViewModelImpl>()) {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Puppy Adoption") },
                actions = {
                    Icon(
                        imageVector = Icons.Default.SquareFoot,
                        contentDescription = "Switch to grid view"
                    )
                }
            )
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = AppGraph.PuppyList.route
        ) {
            composable(route = AppGraph.PuppyList.route) { backStackEntry ->
                val puppyListViewModel: PuppyListViewModel = viewModel<PuppyListViewModelImpl>(
                    factory = HiltViewModelFactory(LocalContext.current, backStackEntry)
                )
                PuppyListUi.Layout(puppyListViewModel) { puppy ->
                    puppyDetailViewModel.setupWithPuppy(puppy)
                    navController.navigate(AppGraph.PuppyDetails.route)
                }
            }
            composable(route = AppGraph.PuppyDetails.route,) {
                PuppyDetailUi.Layout(puppyDetailViewModel)
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}