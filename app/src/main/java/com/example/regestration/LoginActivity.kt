package com.example.regestration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.regestration.Api.ApiClient
import com.example.regestration.Api.ApiInterface
import com.example.regestration.Models.LoginRequest
import com.example.regestration.Models.LoginResponse
import com.example.regestration.Models.RegestrationResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var etemail:EditText
    lateinit var etPassword:EditText
    lateinit var btnlogin:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setViews()
    }

    fun  setViews(){
        etemail=findViewById(R.id.etemail)
        etPassword=findViewById(R.id.etPassword)
        btnlogin=findViewById(R.id.btnlogin)
    }

    fun clickLogin(){
        var error = false
        btnlogin.setOnClickListener{
            var email=etemail.text.toString()
            if(email.isEmpty())
                etemail.setError("Email is required")
        }
        var password=etPassword.text.toString()
        if(password.isEmpty()){
            etPassword.setError("password is required")

        }
        var loginRequest=LoginRequest(
            Email="Email",
            Password="Password"

        )
        btnlogin.setOnClickListener {
            var intent=Intent(baseContext,CoursesDetail::class.java)
            startActivity(intent)
        }

        var retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = retrofit.loginStudent(loginRequest)
        request.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful)
                    Toast.makeText(baseContext, "Login Successful", Toast.LENGTH_LONG)
                        .show()
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}
