package com.example.regestration.Models

import com.google.gson.annotations.SerializedName

data class RegestrationRequest(
    var name:String,
    var email:String,
    var password:String,
    @SerializedName("date_of_birth")var dateOfBirth:String,
    var nationality:String,
    @SerializedName("phone_number")var phoneNumber:String
)
