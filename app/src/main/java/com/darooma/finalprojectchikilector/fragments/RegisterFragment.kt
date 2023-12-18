package com.darooma.finalprojectchikilector.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.darooma.finalprojectchikilector.R
import com.darooma.finalprojectchikilector.databinding.FragmentRegisterBinding
import com.darooma.finalprojectchikilector.utils.GeneralTools

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //_binding = FragmentRegisterBinding.bind(view)


        binding.btnRegister.setOnClickListener {

            if (binding.etPassword.text!!.isBlank() || binding.etUser.text!!.isBlank() ){
                GeneralTools.sendAlert("Alerta", "Se deben llenar todos los campos", requireContext())
            }else if(binding.etUser.text!!.length < 5  || binding.etUser.text!!.length > 10){
                GeneralTools.sendAlert("Alerta", "El usuario debe tener minimo 5 carácteres y máximo 10", requireContext())
            }else if(binding.etPassword.text!!.length < 8 || binding.etPassword.text!!.length > 15){
                GeneralTools.sendAlert("Alerta", "La contraseña debe tener al menos 8 carácteres y máximo 15" , requireContext())
            }else if(!binding.etPassword.text!!.toString().equals(binding.etPasswordConfirm.text.toString())){
                // verificar que coinciden
                GeneralTools.sendAlert("Alerta", "Las contraseñas no coinciden" , requireContext())
            }else{

                //agregar parametros para que los maneje Avatar
                //Se maneja padre para cambiar de fragnen
                //val bundle = Bundle()
                //bundle.putString("USER_NAME", binding.etUser.text.toString())
                //bundle.putString("USER_PASS", binding.etPassword.text.toString())
                parentFragmentManager.beginTransaction()
                    .addToBackStack("AvatarSelectFragment")
                    .replace(R.id.fragmentContainerInit, AvatarSelectFragment.newInstance(binding.etUser.text.toString(), binding.etPassword.text.toString()))
                    .commit()

                //findNavController().navigate(R.id.action_registerFragment_to_avatarSelectFragment, bundle)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = RegisterFragment()
    }

}