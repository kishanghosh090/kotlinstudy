package com.example.composecrashcourse.ui.users

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composecrashcourse.data.remote.RetrofitClient
import com.example.composecrashcourse.data.repository.UserRepository
import com.example.composecrashcourse.ui.components.UserCard

@Composable
fun UsersScreen() {

    val factory = remember {
        UsersViewModelFactory(
            UserRepository(RetrofitClient.api)
        )
    }

    val viewModel: UsersViewModel = viewModel(factory = factory)
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    when (state) {
        is UsersUiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is UsersUiState.Success -> {
            val users = (state as UsersUiState.Success).users
            LazyColumn {
                items(users) { user ->
                    UserCard(user)
                }
            }
        }

        is UsersUiState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Something went wrong")
            }
        }
    }
}
