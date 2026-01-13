package com.example.composecrashcourse.data.repository

import com.example.composecrashcourse.data.remote.ApiService
import com.example.composecrashcourse.domain.model.User

class UserRepository(
    private val api: ApiService
) {

    suspend fun getUsers(): List<User> {
        return api.getUsers().map {
            User(
                id = it.id,
                name = it.name,
                favTea = it.favTea
            )
        }
    }
}
