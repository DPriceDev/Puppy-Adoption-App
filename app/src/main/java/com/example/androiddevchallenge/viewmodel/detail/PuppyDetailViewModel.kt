package com.example.androiddevchallenge.viewmodel.detail

import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.model.Puppy
import javax.inject.Inject

interface PuppyDetailViewModel {
    fun setupWithPuppy(puppy: Puppy)
    fun adoptPuppy()
}

class PuppyDetailViewModelImpl @Inject constructor()
    : ViewModel(), PuppyDetailViewModel {

    override fun setupWithPuppy(puppy: Puppy) {
        TODO("Not yet implemented")
    }

    override fun adoptPuppy() {
        TODO("Not yet implemented")
    }
}