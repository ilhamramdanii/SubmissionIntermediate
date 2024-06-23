package com.dicoding.submissionintermediate.di

import android.content.Context
import com.dicoding.submissionintermediate.data.pref.UserPreference
import com.dicoding.submissionintermediate.data.pref.dataStore
import com.dicoding.submissionintermediate.data.remote.UserRepository
import com.dicoding.submissionintermediate.data.remote.retrofit.ApiConfig

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val apiService = ApiConfig.getApiService()
        val userPreference = UserPreference.getInstance(context.dataStore)
        return UserRepository.getInstance(userPreference, apiService)
    }
}
