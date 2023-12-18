package com.darooma.finalprojectchikilector.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.lifecycleScope
import com.darooma.finalprojectchikilector.R
import com.darooma.finalprojectchikilector.data.ChikilectorRepository
import com.darooma.finalprojectchikilector.data.db.model.Game1Words
import com.darooma.finalprojectchikilector.databinding.FragmentSettingsMainBinding
import com.darooma.finalprojectchikilector.databinding.FragmentVowelsBinding
import com.darooma.finalprojectchikilector.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import kotlin.random.Random


class VowelsFragment : Fragment() {

    private var _binding: FragmentVowelsBinding? = null
    private val binding get() = _binding!!

    private lateinit var repository: ChikilectorRepository

    lateinit var vowelWord : Game1Words

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentVowelsBinding.inflate(inflater, container, false)
        repository = (activity?.application as com.darooma.finalprojectchikilector.application.ChikilectorDBApp).repository

        val ini = 0
        val end = 25
        val ran = Random.nextInt(ini, end )
        println(ran)
        //Se selecciona que imagen sera
        vowelWord = Constants.GAME1_WORDS[ran]
        //Se agrega imagen
        val resourceId = resources.getIdentifier(vowelWord.image, "drawable",context?.packageName)
        binding.imgGuess.setImageResource(resourceId)
        //Se agregan listeners botones
        binding.lttrA.setOnClickListener {
            //LLamar funcion con "a"
            verifyVowelSelected("a")
        }
        binding.lttrE.setOnClickListener {
            //LLamar funcion con "e"
            verifyVowelSelected("e")
        }
        binding.lttrI.setOnClickListener {
            //LLamar funcion con "i"
            verifyVowelSelected("i")
        }
        binding.lttrO.setOnClickListener {
            //LLamar funcion con "o"
            verifyVowelSelected("o")
        }
        binding.lttrU.setOnClickListener {
            //LLamar funcion con "u"
            verifyVowelSelected("u")
        }
        //TODO Agregar tache para salir
        //TODO Agregar funcionalidad a flecha atras para que regrese a home
        return binding.root
    }

    private fun verifyVowelSelected(v: String) {
        if (v == vowelWord.vowel){
            // Mandar paloma a imagen
            binding.imgIscheck.setImageResource(R.drawable.check)
            // Sumar cuenta a gnrl

            try {
                CoroutineScope(Dispatchers.IO).launch  {
                    val user = repository.getActualSessionUser()
                    if (user != null) {
                        repository.add1ProgressGame1(user.idUser)
                    }
                }
            }catch(e: Exception){
                Log.d("ERROR", "Fallo al obtener usuario actual o al actualizar")
            }

        }else{
            // Mandar tache a imagen
            binding.imgIscheck.setImageResource(R.drawable.check_out)
        }

        parentFragmentManager.beginTransaction().replace(R.id.fCFragmentGameContainer, VowelsFragment()).commit()
    }


}