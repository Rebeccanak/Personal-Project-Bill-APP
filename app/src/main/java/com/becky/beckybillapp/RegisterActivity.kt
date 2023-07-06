package com.becky.beckybillapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.becky.beckybillapp.databinding.ActivityMainBinding
import com.becky.beckybillapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSignUp.setOnClickListener {
//            val intent = Intent(this,LoginActivity::class.java)
//
//            startActivity(intent)
            validateForm()
            clearErrors()

        }


    }
    fun validateForm(){
        val firstName = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val email = binding.etEmail.text.toString()
        val phoneNumber = binding.etPhoneNumber.text.toString()
        val password = binding.etPassword.text.toString()
        val confirmPassword = binding.etConfirmPassword.text.toString()

        var error = false

        if (firstName.isBlank()){
            binding.tilFirstName.error = "First Name is required"
            error = true
        }
        if (lastName.isBlank()){
            binding.tilLastName.error = "Last Name is required"
            error =true
        }
        if (email.isBlank()){
            binding .tilEmail.error = "Email is required"
            error = true

        }
        if (phoneNumber.isBlank()){
            binding.tilPhoneNumber.error = "Phone number is required"
            error = true
        }
        if (password.isBlank()){
            binding.tilPassword.error = "Password is required"
            error = true
        }
        if (confirmPassword.isBlank()){
            binding.tilConfirmPassword.error = "Confirm Password is required"
            error = true
        }
        if (!error){
            val intent = Intent(this, LoginActivity:: class.java)
            startActivity(intent)
            Toast.makeText(this,"$firstName $lastName $email $phoneNumber $password $confirmPassword",
            Toast.LENGTH_LONG).show()
            finish()
        }
    }
    fun clearErrors(){
        binding.tilFirstName.error = null
        binding.tilLastName.error = null
        binding.tilEmail.error = null
        binding.tilPhoneNumber.error = null
        binding.tilPassword.error = null
        binding.tilConfirmPassword.error = null

    }
}