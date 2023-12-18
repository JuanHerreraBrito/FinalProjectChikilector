package com.darooma.finalprojectchikilector

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.darooma.finalprojectchikilector.databinding.ActivityInitBinding

class InitActivity : AppCompatActivity() {

    private lateinit var binding : ActivityInitBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInitBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.goToLogin.setOnClickListener {
//            val loginIntent = Intent(this, LoginRegisterActivity::class.java)
//            startActivity(loginIntent)
//        }
//        binding.goToLogin.setOnClickListener {
//            val registerIntent = Intent(this, LoginRegisterActivity::class.java)
//            startActivity(registerIntent)
//        }
    }

}