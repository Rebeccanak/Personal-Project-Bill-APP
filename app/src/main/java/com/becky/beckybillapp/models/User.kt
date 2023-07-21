package com.becky.beckybillapp.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("phone_Number")var phoneNumber: String,
    @SerializedName("first_name") var firstName: String,
    @SerializedName("userId") var userId: String,
    @SerializedName("last_name")var lastName: String,

)
