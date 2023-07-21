
package com.becky.beckybillapp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.becky.beckybillapp.databinding.ActivityRegisterBinding
import com.becky.beckybillapp.models.RegisterRequest
import com.becky.beckybillapp.viewmodel.UserViewModel


class RegisterActivity : AppCompatActivity() {
    val userViewModel: UserViewModel by viewModels()
    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()
        binding.tvRegister.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignUp.setOnClickListener{
            clearErrors()
            validateSignUp()
        }
        userViewModel.regLiveData.observe(this, Observer { regResponse ->
            Toast.makeText(this,regResponse.message,Toast.LENGTH_LONG).show()
            startActivity(Intent(this,LoginActivity::class.java))
            binding.pbRegister.visibility=View.GONE
        })
        userViewModel.regLiveData.observe(this, Observer { err ->
            Toast.makeText(this,err.message,Toast.LENGTH_LONG).show()
            binding.pbRegister.visibility=View.GONE
        })
        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
        binding.tvLogin.setOnClickListener {
            startActivity(Intent(this, HomePage::class.java))

        }
    }

    fun validateSignUp() {
        val firstName=binding.etFirstName.text.toString()
        val lastName=binding.etLastName.text.toString()
        val phoneNumber=binding.etPhoneNumber.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        val confirm=binding.etConfirmPassword.text.toString()
        var error = false

        if (firstName.isBlank()) {
            error = true
            binding.tilFirstName.error = "First name is required"
        }
        if (lastName.isBlank()) {
            binding.tilFirstName.error = "First name is required"
            error = true
        }
        if (lastName.isBlank()) {
            binding.tilFirstName.error = "First name is required"
            error = true
        }
        if (email.isBlank()) {
            binding.tilEmail.error = "Email is required"
            error = true
        }
        if (password.isBlank()) {
            binding.tilPassword.error = "Password is required"
            error = true
        }
        if (phoneNumber.isBlank()) {
            binding.tilPhoneNumber.error = "Your phone number is required"
            error = true
        }
        if(!error){
            val registerRequest= RegisterRequest(
                firstName =firstName,
                lastName = lastName,
                email=email,
                phoneNumber= phoneNumber,
                password = password,
            )
            userViewModel.registerUser(registerRequest)
            Toast.makeText(this,"Registration of $firstName" +
                    " was sucessful",
                Toast.LENGTH_LONG).show()
        }
    }
    fun clearErrors() {
        binding.tilFirstName.error = null
        binding.tilLastName
        binding.tilEmail.error = null
        binding.tilPassword.error = null
        binding.tilPhoneNumber.error = null
        binding.tilConfirmPassword.error=null
    }
}
























































//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Toast
//import androidx.activity.viewModels
//import com.becky.beckybillapp.databinding.ActivityMainBinding
//import com.becky.beckybillapp.databinding.ActivityRegisterBinding
//import com.becky.beckybillapp.models.RegisterRequest
//import com.becky.beckybillapp.viewmodel.UserViewModel
//
//class RegisterActivity : AppCompatActivity() {
//    val userViewModel: UserViewModel by viewModels()
//    lateinit var binding: ActivityRegisterBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityRegisterBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
////            binding.pdRegister.visibility = view.GONE
//            }
//
//    override fun onResume() {
//        super.onResume()
//    binding.tvRegister.setOnClickListener {
//        val intent = Intent(this,LoginActivity::class.java)
//        startActivity(intent)
//
//        }
//        binding.btnSignUp.setOnClickListener{
//
//        }
//            validateForm()
//            clearErrors()
//
//            userViewModel.regLiveData.observe(this) { regResponse ->
//                Toast.makeText(this, regResponse.message, Toast.LENGTH_LONG).show()
//        }
//
//            userViewModel.errorLiveData.observe(this) { err ->
//                Toast.makeText(this, err, Toast.LENGTH_LONG).show()
//            }
////        binding. tvLogin.setOnClickListener {
////            startActivity(Intent(this, LoginActivity:: class.java))
////        }
//    }
//    fun validateForm(){
//        val firstName = binding.etFirstName.text.toString()
//        val lastName = binding.etLastName.text.toString()
//        val email = binding.etEmail.text.toString()
//        val phoneNumber = binding.etPhoneNumber.text.toString()
//        val password = binding.etPassword.text.toString()
//        val confirmPassword = binding.etConfirmPassword.text.toString()
//
//        var error = false
//
//        if (firstName.isBlank()){
//            binding.tilFirstName.error = "First Name is required"
//            error = true
//        }
//        if (lastName.isBlank()){
//            binding.tilLastName.error = "Last Name is required"
//            error =true
//        }
//        if (email.isBlank()){
//            binding .tilEmail.error = "Email is required"
//            error = true
//
//        }
//        if (phoneNumber.isBlank()){
//            binding.tilPhoneNumber.error = "Phone number is required"
//            error = true
//        }
//        if (password.isBlank()){
//            binding.tilPassword.error = "Password is required"
//            error = true
//        }
//        if (confirmPassword.isBlank()){
//            binding.tilConfirmPassword.error = "Confirm Password is required"
//            error = true
//        }
//        if (!error){
//            val registerRequest = RegisterRequest(
//                firstName = firstName,
//                lastName = lastName,
//                email = email,
//                phoneNumber = phoneNumber,
//                password = password
//
//            )
////  binding.pbRegister.visibility= view. VISIBLE
//            userViewModel.registerUser(registerRequest)
//            Toast.makeText(this,"Registration of $firstName" +
//                    " was sucessful",
//                Toast.LENGTH_LONG).show()
//
////            val intent = Intent(this, LoginActivity:: class.java)
//////            startActivity(intent)
////            Toast.makeText(this,"$firstName $lastName $email $phoneNumber $password $confirmPassword",
////            Toast.LENGTH_LONG).show()
////            finish()
//        }
//    }
//    fun clearErrors(){
//        binding.tilFirstName.error = null
//        binding.tilLastName.error = null
//        binding.tilEmail.error = null
//        binding.tilPhoneNumber.error = null
//        binding.tilPassword.error = null
//        binding.tilConfirmPassword.error = null
//
//    }
//}