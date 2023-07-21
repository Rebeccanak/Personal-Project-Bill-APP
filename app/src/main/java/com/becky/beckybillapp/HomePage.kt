package com.becky.beckybillapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.becky.beckybillapp.databinding.ActivityHomePageBinding
import com.becky.beckybillapp.databinding.ActivityRegisterBinding
import com.becky.beckybillapp.ui.MainActivity

class HomePage : AppCompatActivity() {
    lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        }


    }
