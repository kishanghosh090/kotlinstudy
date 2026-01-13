package com.example.composecrashcourse.ui.users

import com.example.composecrashcourse.domain.model.User

sealed class UsersUiState {
    object Loading : UsersUiState()
    data class Success(val users: List<User>) : UsersUiState()
    data class Error(val message: String) : UsersUiState()
}
