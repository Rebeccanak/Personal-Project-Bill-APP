package com.becky.beckybillapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.becky.beckybillapp.databinding.ActivityLoginBinding
import com.becky.beckybillapp.ui.MainActivity
import com.becky.beckybillapp.viewmodel.UserViewModel


class LoginActivity : AppCompatActivity() {
    val userViewModel : UserViewModel by viewModels ()
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, HomePage:: class.java)

            startActivity(intent)
        }
        validateForm()
        clearErrors()

        userViewModel.regLiveData.observe(this) { regResponse ->
            Toast.makeText(this, regResponse.message, Toast.LENGTH_LONG).show()
        }
        userViewModel.errorLiveData.observe(this) { err ->
            Toast.makeText(this, err, Toast.LENGTH_LONG).show()
        }
    }
    fun validateForm(){
        val userName = binding.etUserName.text.toString()
        val emailAddress = binding.etEmailAddress.text.toString()
        val phone = binding.etPhone.text.toString()
        val passwordHere = binding.etPasswordHere.text.toString()


        var error = false

        if (userName.isBlank()){
            binding.tilUserName.error = "First Name is required"
            error = true
        }
        if (emailAddress.isBlank()){
            binding.tilEmailAddress.error = "Last Name is required"
            error =true
        }
        if (phone.isBlank()){
            binding .tilPhone.error = "Email is required"
            error = true

        }
        if (passwordHere.isBlank()){
            binding.tilPasswordHere.error = "Phone number is required"
            error = true
        }

        if (!error){
            val intent = Intent(this, LoginActivity:: class.java)
            startActivity(intent)
            Toast.makeText(this,"$userName $emailAddress $phone $passwordHere ",
                Toast.LENGTH_LONG).show()
            finish()
        }
    }
    fun clearErrors(){
        binding.tilUserName.error = null
        binding.tilEmailAddress.error = null
        binding.tilPhone.error = null
        binding.tilPasswordHere.error = null



    }
}
