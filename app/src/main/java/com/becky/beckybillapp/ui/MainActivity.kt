package com.becky.beckybillapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.becky.beckybillapp.LoginActivity
import com.becky.beckybillapp.RegisterActivity
import com.becky.beckybillapp.databinding.ActivityMainBinding
import com.becky.beckybillapp.databinding.ActivityRegisterBinding
import com.becky.beckybillapp.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        }

    override fun onResume() {
        super.onResume()
    binding.btnRegister.setOnClickListener {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}


}