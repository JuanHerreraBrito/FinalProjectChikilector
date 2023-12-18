package com.darooma.finalprojectchikilector.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.darooma.finalprojectchikilector.HomeActivity
import com.darooma.finalprojectchikilector.R
import com.darooma.finalprojectchikilector.data.ChikilectorRepository
import com.darooma.finalprojectchikilector.data.db.model.SessionEntity
import com.darooma.finalprojectchikilector.data.db.model.UserEntity
import com.darooma.finalprojectchikilector.databinding.FragmentLoginBinding
import com.darooma.finalprojectchikilector.databinding.FragmentRegisterBinding
import com.darooma.finalprojectchikilector.utils.GeneralTools
import kotlinx.coroutines.launch
import java.io.IOException

class LoginFragment : Fragment(R.layout.fragment_login) {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var repository: ChikilectorRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        repository = (activity?.application as com.darooma.finalprojectchikilector.application.ChikilectorDBApp).repository
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            //Check for correct values //update: check for correct login
            if (binding.etUsuario.text!!.isBlank()  || binding.etPassword.text!!.isBlank()) {
                GeneralTools.sendAlert("Alerta", "Favor de llenar todos los campos", requireContext())
            }else{
                try{
                    lifecycleScope.launch {
                        //revisar usuario
                        var userEntity = repository.getUserByName( binding.etUsuario.text.toString() )


                        if (userEntity != null) {
                            val id : Long = userEntity.idUser
                            //Revisar que coincida con password
                            if(userEntity.password == binding.etPassword.text.toString()){
                                repository.insertSession(SessionEntity(
                                    id_usuario = id
                                ))
                                val homeIntent = Intent(requireContext(), HomeActivity::class.java).apply {  }

                                //Inicia sesión
                                startActivity(homeIntent)
                            }else{
                                GeneralTools.sendAlert("Alerta", "La contraseña no es correcta", requireContext())
                            }
                        }else{
                            GeneralTools.sendAlert("Alerta", "El usuario no existe", requireContext())
                        }

                    }
                }catch(e: IOException){
                    Log.d("ERROR", "Fallo el login de Usuario")
                }

            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}