package com.becky.beckybillapp.userReponsotory

import com.becky.beckybillapp.api.ApiClient
import com.becky.beckybillapp.api.ApiInterface
import com.becky.beckybillapp.models.RegisterRequest
import com.becky.beckybillapp.models.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserReponsitory {
    var client = ApiClient.buildClient(ApiInterface::class.java)
    suspend fun registerUser(registerRequest: RegisterRequest):
            Response<RegisterResponse> {
        return withContext(Dispatchers.IO) {
            client.registerUser(registerRequest)

        }

    }
}