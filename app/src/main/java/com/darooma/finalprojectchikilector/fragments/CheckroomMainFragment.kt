package com.darooma.finalprojectchikilector.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.darooma.finalprojectchikilector.R
import com.darooma.finalprojectchikilector.data.ChikilectorRepository
import com.darooma.finalprojectchikilector.databinding.FragmentCheckroomMainBinding
import com.darooma.finalprojectchikilector.databinding.FragmentHomeMainBinding
import com.darooma.finalprojectchikilector.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

class CheckroomMainFragment : Fragment() {

    private var _binding: FragmentCheckroomMainBinding? = null
    private val binding get() = _binding!!

    private var actualSection = Constants.TYPE_HEAD;
    private lateinit var repository: ChikilectorRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    fun saveStuffElection(avatarStuff : Long, type : String){
        //repository = (activity?.application as com.darooma.finalprojectchikilector.application.ChikilectorDBApp).repository
        try{
            CoroutineScope(Dispatchers.IO).launch {
                val user = repository.getActualSessionUser()
                if (user != null){
                    repository.updateUserStuffByType(avatarStuff = avatarStuff, idUser = user.idUser, type = type)
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
        _binding = FragmentCheckroomMainBinding.inflate(inflater, container, false)
        binding.ibChechroomHead.setOnClickListener {
            actualSection = Constants.TYPE_HEAD
            binding.ibStuff1.setImageResource(R.drawable.avatar_head1)
            binding.ibStuff2.setImageResource(R.drawable.avatar_head2)
            binding.ibStuff3.setImageResource(R.drawable.avatar_head3)
        }

        binding.ibChechroomArms.setOnClickListener {
            actualSection = Constants.TYPE_HANDS
            binding.ibStuff1.setImageResource(R.drawable.avatar_hand1)
            binding.ibStuff2.setImageResource(R.drawable.avatar_hand2)
            binding.ibStuff3.setImageResource(R.drawable.avatar_hand3)
        }

        binding.ibChechroomShoes.setOnClickListener {
            actualSection = Constants.TYPE_SHOES
            binding.ibStuff1.setImageResource(R.drawable.avatar_shoes1)
            binding.ibStuff2.setImageResource(R.drawable.avatar_shoes2)
            binding.ibStuff3.setImageResource(R.drawable.avatar_shoes3)
        }

        repository = (activity?.application as com.darooma.finalprojectchikilector.application.ChikilectorDBApp).repository

        binding.ibStuff1.setOnClickListener {
            saveStuffElection(1,actualSection)
            /*try{
                lifecycleScope.launch {
                    val user = repository.getActualSessionUser()
                    if (user != null){
                        repository.updateUserStuffByType(avatarStuff = 1, idUser = user.idUser, type = actualSection)
                    }
                }
            }catch(e: IOException){
                Log.d("ERROR", "Fallo al obtener usuario actual")
            }*/
        }

        binding.ibStuff2.setOnClickListener {
            saveStuffElection(2,actualSection)
            /*
            try{
                lifecycleScope.launch {
                    val user = repository.getActualSessionUser()
                    if (user != null){
                        repository.updateUserStuffByType(avatarStuff = 2, idUser = user.idUser, type = actualSection)
                    }
                }
            }catch(e: IOException){
                Log.d("ERROR", "Fallo al obtener usuario actual")
            }*/
        }

        binding.ibStuff3.setOnClickListener {
            saveStuffElection(3,actualSection)
            /*try{
                lifecycleScope.launch {
                    val user = repository.getActualSessionUser()
                    if (user != null){
                        repository.updateUserStuffByType(avatarStuff = 3, idUser = user.idUser, type = actualSection)
                    }
                }
            }catch(e: IOException){
                Log.d("ERROR", "Fallo al obtener usuario actual")
            }*/
        }


        return binding.root
    }

}