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
import com.darooma.finalprojectchikilector.databinding.FragmentLoginBinding
import com.darooma.finalprojectchikilector.databinding.FragmentSettingsMainBinding
import kotlinx.coroutines.launch
import java.io.IOException


class SettingsMainFragment : Fragment() {

    private var _binding: FragmentSettingsMainBinding? = null
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
        _binding = FragmentSettingsMainBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        try{
            lifecycleScope.launch {
                val user = repository.getActualSessionUser()
                if (user != null){
                    binding.tvUserName.text = user?.userName.toString()
                    if (user.avatarSelected == 1 ){
                        binding.ivAvatar.setImageResource(R.drawable.avatar1v)
                    }else{
                        binding.ivAvatar.setImageResource(R.drawable.avatar2r)
                    }
                }

            }
        }catch(e: IOException){
            Log.d("ERROR", "Fallo al obtener usuario actual")
        }

        binding.ibCerraSesion.setOnClickListener {
            try{
                lifecycleScope.launch {
                    repository.deleteAllSessions()
                    val intent = Intent(context, InitActivity::class.java)
                    startActivity(intent)
                }
            }catch(e: IOException){
                Log.d("ERROR", "Fallo el borrado de la sesión")
            }
        }


    }



}