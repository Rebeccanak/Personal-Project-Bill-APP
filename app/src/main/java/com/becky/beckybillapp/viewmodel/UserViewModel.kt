package com.becky.beckybillapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.becky.beckybillapp.models.RegisterRequest
import com.becky.beckybillapp.models.RegisterResponse
import com.becky.beckybillapp.userReponsotory.UserReponsitory
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    val regLiveData = MutableLiveData<RegisterResponse>()
    val errorLiveData = MutableLiveData<String>()
    val userReponsitory = UserReponsitory()

    fun registerUser(registerRequest: RegisterRequest){
        viewModelScope.launch {
            val response = userReponsitory.registerUser(registerRequest)
            if (response.isSuccessful){
                regLiveData.postValue(response.body())

            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}