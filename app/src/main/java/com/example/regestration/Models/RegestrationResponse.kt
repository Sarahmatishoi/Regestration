package com.example.regestration.Models

import com.google.gson.annotations.SerializedName

data class RegestrationResponse(
    var name:String,
    var email:String,
    @SerializedName("phone_number")var phoneNumber:String,
    var nationality:String,
    @SerializedName("date_of_birth")var dateOfBirth:String,
    var password:String
)
