package com.darooma.finalprojectchikilector.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.darooma.finalprojectchikilector.HomeActivity
import com.darooma.finalprojectchikilector.R
import com.darooma.finalprojectchikilector.data.ChikilectorRepository
import com.darooma.finalprojectchikilector.data.db.model.SessionEntity
import com.darooma.finalprojectchikilector.data.db.model.UserEntity
import com.darooma.finalprojectchikilector.databinding.FragmentAvatarSelectBinding
import kotlinx.coroutines.NonDisposableHandle.parent
import kotlinx.coroutines.launch
import java.io.IOException


class AvatarSelectFragment : Fragment() {

    private var _binding: FragmentAvatarSelectBinding? = null
    private val binding get() = _binding!!

    private var userName : String = ""
    private var userPass : String = ""

    private lateinit var repository: ChikilectorRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            userName = it.getString("USER_NAME").toString()
            userPass = it.getString("USER_PASS").toString()
        }

        repository = (activity?.application as com.darooma.finalprojectchikilector.application.ChikilectorDBApp).repository
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_avatar_select, container, false)

        _binding = FragmentAvatarSelectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Toast.makeText(context, "EL texto es $userName", Toast.LENGTH_SHORT).show()

        binding.idIBAvatar1.setOnClickListener {
            saveInitUserAndSetSession(userName, userPass, 1)

            val intent = Intent(context, HomeActivity::class.java).apply {
                print("guardar el avatar")
            }
            startActivity(intent)
        }

        binding.idIBAvatar2.setOnClickListener {
            saveInitUserAndSetSession(userName, userPass, 2)

            val intent = Intent(context, HomeActivity::class.java).apply {
                print("guardar el avatar")
            }
            startActivity(intent)
        }
    }

    private fun saveInitUserAndSetSession(userName: String, userPass: String, avatarSelected: Int) {
        try{
            lifecycleScope.launch {

                val id :Long = repository.insertUser(UserEntity(userName = userName,
                    password = userPass,
                    avatarSelected = avatarSelected,
                    head = 0, hands = 0, shoes = 0, progress_game1 = 0))

                repository.insertSession(SessionEntity(
                    id_usuario = id
                ))

            }
        }catch(e: IOException){
            Log.d("ERROR", "Fallo el ingreso del Usuario")
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(userName : String, userPass : String) = AvatarSelectFragment().apply {
            arguments = Bundle().apply {
                putString("USER_NAME", userName)
                putString("USER_PASS", userPass)
            }
        }
    }

}