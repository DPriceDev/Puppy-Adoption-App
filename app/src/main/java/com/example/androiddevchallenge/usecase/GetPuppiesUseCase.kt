package com.example.androiddevchallenge.usecase

import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.model.SortType
import com.example.androiddevchallenge.repository.PuppyRepository
import javax.inject.Inject

interface GetPuppiesUseCase {
    fun getPuppies(sortType: SortType) : Map<Char, List<Puppy>>
}

class GetPuppiesUseCaseImpl @Inject constructor(private val puppyRepository: PuppyRepository)
    : GetPuppiesUseCase {
    override fun getPuppies(sortType: SortType) : Map<Char, List<Puppy>> {
        return puppyRepository.getPuppies().sortedBy {
            when(sortType) {
                SortType.NAME -> it.name
                SortType.BREED -> it.breed
            }
        }.groupBy {
            when(sortType) {
                SortType.NAME -> it.name.first()
                SortType.BREED -> it.breed.first()
            }
        }
    }
}