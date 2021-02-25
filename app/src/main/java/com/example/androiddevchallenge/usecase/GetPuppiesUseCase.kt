package com.example.androiddevchallenge.usecase

import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.repository.PuppyRepository
import javax.inject.Inject

interface GetPuppiesUseCase {
    fun getPuppies() : List<Puppy>
}

class GetPuppiesUseCaseImpl @Inject constructor(private val puppyRepository: PuppyRepository)
    : GetPuppiesUseCase {
    override fun getPuppies() : List<Puppy> {
        return puppyRepository.getPuppies()
    }
}