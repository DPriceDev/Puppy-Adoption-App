package com.example.androiddevchallenge.di

import com.example.androiddevchallenge.repository.PuppyRepository
import com.example.androiddevchallenge.repository.PuppyRepositoryImpl
import com.example.androiddevchallenge.usecase.GetPuppiesUseCase
import com.example.androiddevchallenge.usecase.GetPuppiesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PuppyModule {

    @Binds
    abstract fun GetPuppiesUseCaseImpl.bindGetPuppiesUseCase() : GetPuppiesUseCase

    @Binds
    abstract fun PuppyRepositoryImpl.bindPuppyRepository() : PuppyRepository
}