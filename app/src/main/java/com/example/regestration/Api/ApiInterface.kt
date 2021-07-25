package com.example.regestration.Api

import com.example.regestration.Models.LoginRequest
import com.example.regestration.Models.LoginResponse
import com.example.regestration.Models.RegestrationRequest
import com.example.regestration.Models.RegestrationResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST("/students/register")
    fun registerStudents( @Body regestrationRequest: RegestrationRequest):Call<RegestrationResponse>

    @POST("students/login")
    fun loginStudent(@Body loginRequest: LoginRequest):Call<LoginResponse>
}
