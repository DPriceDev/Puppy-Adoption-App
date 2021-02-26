package com.example.androiddevchallenge.usecase

import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.repository.PuppyRepository
import javax.inject.Inject

interface AdoptPuppyUseCase {
    suspend fun adopt(puppy: Puppy)
}

class AdoptPuppyUseCaseImpl @Inject constructor(private val puppyRepository: PuppyRepository)
    : AdoptPuppyUseCase {

    override suspend fun adopt(puppy: Puppy) {
        TODO("Not yet implemented")
    }
}