package com.darooma.finalprojectchikilector.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.darooma.finalprojectchikilector.HomeActivity
import com.darooma.finalprojectchikilector.InitActivity
import com.darooma.finalprojectchikilector.R
import com.darooma.finalprojectchikilector.data.ChikilectorRepository
import com.darooma.finalprojectchikilector.databinding.FragmentAchievementsMainBinding
import com.darooma.finalprojectchikilector.databinding.FragmentWelcomeBinding
import kotlinx.coroutines.launch
import java.io.IOException

class AchievementsMainFragment : Fragment() {

    private var _binding: FragmentAchievementsMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var repository: ChikilectorRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repository = (activity?.application as com.darooma.finalprojectchikilector.application.ChikilectorDBApp).repository

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAchievementsMainBinding.inflate(inflater, container, false)

        try{
            lifecycleScope.launch {
                val user = repository.getActualSessionUser()
                if (user != null){
                    binding.pbGameVocales1.progress = if(user.progress_game1!! > 10) 100 else (user.progress_game1!!.toInt() * 100).div(10)
                    binding.pbGameVocales2.progress = if(user.progress_game1!! > 25) 100 else (user.progress_game1!!.toInt() * 100).div(25)
                    binding.pbGameVocales3.progress = if(user.progress_game1!! > 40) 100 else (user.progress_game1!!.toInt() * 100).div(40)
                }else{
                    val intent = Intent(context, InitActivity::class.java)
                    startActivity(intent)
                }
            }
        }catch(e: IOException){
            Log.d("ERROR", "Fallo al obtener los logros")
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}