package com.example.androiddevchallenge.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.usecase.GetPuppiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

interface PuppyListViewModel {
    val puppies: List<Puppy>
}

@HiltViewModel
class PuppyListViewModelImpl @Inject constructor(private val getPuppiesUseCase: GetPuppiesUseCase)
    : ViewModel(), PuppyListViewModel {

    override val puppies: List<Puppy> by mutableStateOf(
        listOf(
            Puppy(
                "Henry",
                "Sausage",
                "https://dogtime.com/assets/uploads/2011/03/puppy-development-1280x720.jpg"
            ),
            Puppy(
                "Tom",
                "Hund",
                "https://dogtime.com/assets/uploads/2011/03/puppy-development-1280x720.jpg"
            )
        )
    )
}