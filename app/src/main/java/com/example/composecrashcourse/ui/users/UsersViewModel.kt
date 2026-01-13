package com.example.composecrashcourse.ui.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composecrashcourse.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UsersViewModel(
    private val repository: UserRepository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<UsersUiState>(UsersUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            _uiState.value = UsersUiState.Loading
            try {
                val users = repository.getUsers()
                _uiState.value = UsersUiState.Success(users)
            } catch (e: Exception) {
                _uiState.value = UsersUiState.Error("Failed to load users")
            }
        }
    }
}
