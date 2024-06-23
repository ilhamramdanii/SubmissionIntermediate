package com.dicoding.submissionintermediate.ui.upload

import androidx.lifecycle.ViewModel
import com.dicoding.submissionintermediate.data.remote.UserRepository
import com.dicoding.submissionintermediate.data.remote.response.AddStoryResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MultipartBody
import okhttp3.RequestBody

class UploadViewModel(private val userRepository: UserRepository) : ViewModel() {

    suspend fun uploadImage(file: MultipartBody.Part, description: RequestBody, lat: RequestBody?, lon: RequestBody?): AddStoryResponse {
        return withContext(Dispatchers.IO) {
            userRepository.uploadImage(file, description, lat, lon)
        }
    }
}
