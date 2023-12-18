package com.darooma.finalprojectchikilector.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.darooma.finalprojectchikilector.HomeActivity
import com.darooma.finalprojectchikilector.InitActivity
import com.darooma.finalprojectchikilector.R
import com.darooma.finalprojectchikilector.data.ChikilectorRepository
import com.darooma.finalprojectchikilector.databinding.FragmentWelcomeBinding
import kotlinx.coroutines.launch
import java.io.IOException

class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var repository: ChikilectorRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repository = (activity?.application as com.darooma.finalprojectchikilector.application.ChikilectorDBApp).repository

        try{
            lifecycleScope.launch {
                val user = repository.getActualSessionUser()
                if (user != null){
                    val intent = Intent(context, HomeActivity::class.java)
                    startActivity(intent)
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
        // Inflate the layout for this fragment
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.goToLogin.setOnClickListener {
            parentFragmentManager.beginTransaction().addToBackStack("LoginFragment")
                .replace(R.id.fragmentContainerInit, LoginFragment.newInstance())
                .commit()
            //findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment)
        }

        binding.goToRegister.setOnClickListener {
            parentFragmentManager.beginTransaction().addToBackStack("RegisterFragment")
                .replace(R.id.fragmentContainerInit, RegisterFragment.newInstance())
                .commit()
            //sfindNavController().navigate(R.id.action_welcomeFragment_to_registerFragment)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = WelcomeFragment()
    }


}