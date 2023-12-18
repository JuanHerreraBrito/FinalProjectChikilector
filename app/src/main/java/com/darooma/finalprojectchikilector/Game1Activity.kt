package com.darooma.finalprojectchikilector

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.darooma.finalprojectchikilector.databinding.ActivityGame1Binding
import com.darooma.finalprojectchikilector.databinding.ActivityInitBinding

class Game1Activity : AppCompatActivity() {

    private lateinit var binding : ActivityGame1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGame1Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}