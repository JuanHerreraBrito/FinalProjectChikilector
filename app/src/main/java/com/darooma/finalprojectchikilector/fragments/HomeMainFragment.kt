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
import com.darooma.finalprojectchikilector.R
import com.darooma.finalprojectchikilector.data.ChikilectorRepository
import com.darooma.finalprojectchikilector.databinding.FragmentHomeMainBinding
import com.darooma.finalprojectchikilector.databinding.FragmentWelcomeBinding
import kotlinx.coroutines.launch
import java.io.IOException


class HomeMainFragment : Fragment() {

    private var _binding: FragmentHomeMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var repository: ChikilectorRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        repository = (activity?.application as com.darooma.finalprojectchikilector.application.ChikilectorDBApp).repository

        try{
            lifecycleScope.launch {
                val user = repository.getActualSessionUser()
                if (user != null){
                    if (user.avatarSelected == 1){
                        binding.avatarSelect.setImageResource(R.drawable.home_gavatar)
                    }else{
                        binding.avatarSelect.setImageResource(R.drawable.home_pavata)
                    }

                    when (user.head?.toInt()){
                        1 -> binding.avatarHead.setImageResource(R.drawable.home_set1head)
                        2 -> binding.avatarHead.setImageResource(R.drawable.home_set2head)
                        3 -> binding.avatarHead.setImageResource(R.drawable.home_set3head)
                        else -> {
                            binding.avatarHead.setImageResource(android.R.color.transparent)
                        }
                    }

                    when (user.hands?.toInt()){
                        1 -> binding.avatarHands.setImageResource(R.drawable.home_set1hand)
                        2 -> binding.avatarHands.setImageResource(R.drawable.home_set2hand)
                        3 -> binding.avatarHands.setImageResource(R.drawable.home_set3hand)
                        else -> {
                            binding.avatarHands.setImageResource(android.R.color.transparent)
                        }
                    }

                    when (user.shoes?.toInt()){
                        1 -> binding.avatarShoes.setImageResource(R.drawable.home_set1shoes)
                        2 -> binding.avatarShoes.setImageResource(R.drawable.home_set2shoes)
                        3 -> binding.avatarShoes.setImageResource(R.drawable.home_set3shoes)
                        else -> {
                            binding.avatarHands.setImageResource(android.R.color.transparent)
                        }
                    }
                }
            }
        }catch(e: IOException){
            Log.d("ERROR", "Fallo al obtener usuario actual")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeMainBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onResume() {
        super.onResume()
    }



}