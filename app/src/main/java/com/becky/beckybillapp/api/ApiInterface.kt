package com.becky.beckybillapp.api

import com.becky.beckybillapp.models.RegisterRequest
import com.becky.beckybillapp.models.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("users/register")
   suspend  fun registerUser(@Body registerRequest: RegisterRequest): Response<RegisterResponse>
}