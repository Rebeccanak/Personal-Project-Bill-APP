package com.becky.beckybillapp.models

import android.provider.ContactsContract.CommonDataKinds.Phone
import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("first_name") var firstName: String,
    @SerializedName("last_name") var  lastName: String,
    var email: String,
    var password: String,
    @SerializedName("phone_number") var phoneNumber: String
)
