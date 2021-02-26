package com.example.androiddevchallenge.viewmodel.detail

import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.usecase.AdoptPuppyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

interface PuppyDetailViewModel {
    val puppy: Puppy

    fun setupWithPuppy(puppy: Puppy)
    fun adoptPuppy()
}

@HiltViewModel
class PuppyDetailViewModelImpl @Inject constructor(private val adoptPuppyUseCase: AdoptPuppyUseCase)
    : ViewModel(), PuppyDetailViewModel {

    override var puppy: Puppy by mutableStateOf(Puppy.Default)
        private set

    override fun setupWithPuppy(puppy: Puppy) {
        this.puppy = puppy
    }

    override fun adoptPuppy() {
        viewModelScope.launch {
            adoptPuppyUseCase.adopt(puppy)
        }
    }
}