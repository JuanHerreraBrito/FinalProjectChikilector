package com.darooma.finalprojectchikilector.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.darooma.finalprojectchikilector.Game1Activity
import com.darooma.finalprojectchikilector.HomeActivity
import com.darooma.finalprojectchikilector.R
import com.darooma.finalprojectchikilector.databinding.FragmentGamesMainBinding
import com.darooma.finalprojectchikilector.databinding.FragmentSettingsMainBinding

class GamesMainFragment : Fragment() {

    private var _binding: FragmentGamesMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGamesMainBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ibGame1.setOnClickListener {
            val intent = Intent(context, Game1Activity::class.java).apply {
                print("Ir a juego")
            }
            startActivity(intent)
        }


    }

}