package com.dicoding.submissionintermediate.ui.login


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.submissionintermediate.data.pref.UserModel
import com.dicoding.submissionintermediate.data.remote.UserRepository
import com.dicoding.submissionintermediate.data.remote.response.LoginResponse
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: UserRepository) : ViewModel() {

    suspend fun login(email: String, password: String): LoginResponse {
        return repository.getLogin(email, password)
    }

    fun saveSession(user: UserModel) {
        viewModelScope.launch {
            repository.saveSession(user)
        }
    }
}
