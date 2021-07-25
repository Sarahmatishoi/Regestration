package com.example.regestration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.*
import com.example.regestration.Api.ApiClient
import com.example.regestration.Api.ApiInterface
import com.example.regestration.Models.RegestrationRequest
import com.example.regestration.Models.RegestrationResponse
import com.google.android.material.textfield.TextInputLayout
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    lateinit var spNationality: Spinner
    lateinit var btnbutton: Button
    lateinit var etName: EditText
    lateinit var etphone: EditText
    lateinit var etEmail: EditText
    lateinit var etpassword: EditText
    lateinit var etDob: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews()
    }

    fun castViews() {
        etName = findViewById(R.id.etName)
        etDob = findViewById(R.id.etDob)
        spNationality = findViewById(R.id.spNationality)
        etpassword = findViewById(R.id.etpassword)
        etphone = findViewById(R.id.etphone)
        etEmail = findViewById(R.id.etEmail)
        btnbutton = findViewById(R.id.btnbutton)


        var nationalities = arrayOf("Kenyan", "Rwandan", "South Sudanese", "Ugandan")
        var nationalitiesAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, nationalities)
        nationalitiesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spNationality.adapter = nationalitiesAdapter

        btnbutton.setOnClickListener {
            var intent=Intent(baseContext,LoginActivity::class.java)
            startActivity(intent)
        }

    }

    fun clickRegister() {
        var error = false
        btnbutton.setOnClickListener {
            var name = etName.text.toString()
            if (name.isEmpty()) {
                error = true
                etName.setError("Name is required")
            }
            var dob = etDob.text.toString()
            if (dob.isEmpty()) {
                error = true
                etDob.setError("Date of birth is required")
            }
            var nationality = spNationality.selectedItem.toString()
            if (nationality.isEmpty()) {
                error = true
                spNationality.dropDownHorizontalOffset
            }
            var password = etpassword.text.toString()
            if (password.isEmpty()) {
                error = true
                etpassword.setError("password is required")
            }
            var phone = etphone.text.toString()
            if (phone.isEmpty()) {
                error = true
                etphone.setError("phoneNumber is required")
            }
            var email = etEmail.text.toString()
            if (email.isEmpty()) {
                error = true
                etEmail.setError("Name is required")
            }

            var regestrationRequest = RegestrationRequest(
                name = name,
                phoneNumber = phone,
                email = email,
                nationality = nationality,
                dateOfBirth = dob,
                password = password
            )

            var retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
            var request = retrofit.registerStudents(regestrationRequest)
            request.enqueue(object : Callback<RegestrationResponse> {
                override fun onResponse(
                    call: Call<RegestrationResponse>,
                    response: Response<RegestrationResponse>
                ) {
                    if (response.isSuccessful)
                        Toast.makeText(baseContext, "Registration Successful", Toast.LENGTH_LONG)
                            .show()
                }


                override fun onFailure(call: Call<RegestrationResponse>, t: Throwable) {
                        Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()

                    }

                })

            }
        }
    }



