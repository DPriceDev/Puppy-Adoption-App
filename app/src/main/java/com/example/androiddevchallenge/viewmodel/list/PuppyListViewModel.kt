package com.example.androiddevchallenge.viewmodel.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.model.SortType
import com.example.androiddevchallenge.usecase.GetPuppiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

interface PuppyListViewModel {
    val puppies: Map<Char, List<Puppy>>
}

@HiltViewModel
class PuppyListViewModelImpl @Inject constructor(private val getPuppiesUseCase: GetPuppiesUseCase)
    : ViewModel(), PuppyListViewModel {

    override val puppies: Map<Char, List<Puppy>> by mutableStateOf(
        getPuppiesUseCase.getPuppies(SortType.NAME)
    )
}