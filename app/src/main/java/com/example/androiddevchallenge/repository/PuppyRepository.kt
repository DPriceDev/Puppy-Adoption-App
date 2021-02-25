package com.example.androiddevchallenge.repository

import com.example.androiddevchallenge.model.Puppy
import javax.inject.Inject

interface PuppyRepository {
    fun getPuppies() : List<Puppy>
}

class PuppyRepositoryImpl @Inject constructor() : PuppyRepository {

    override fun getPuppies() : List<Puppy> {
        return listOf(
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
    }
}