package com.example.composecrashcourse.data.remote

import retrofit2.http.GET
import com.example.composecrashcourse.data.model.UserDto

interface ApiService {
    @GET("getUsers")
    suspend fun getUsers(): List<UserDto>
}
