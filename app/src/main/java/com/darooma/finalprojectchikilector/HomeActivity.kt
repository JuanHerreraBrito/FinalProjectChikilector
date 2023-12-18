package com.darooma.finalprojectchikilector


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.darooma.finalprojectchikilector.fragments.*
import com.darooma.finalprojectchikilector.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeMainFragment() )

        binding.btnNavViewMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navHome -> replaceFragment(HomeMainFragment())
                R.id.navCheckroom -> replaceFragment(CheckroomMainFragment())
                R.id.navGames -> replaceFragment(GamesMainFragment())
                R.id.navAchievements -> replaceFragment(AchievementsMainFragment())
                R.id.navSettings -> replaceFragment(SettingsMainFragment())
                else->{
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fLFragmentsContainer, fragment)
        fragmentTransaction.commit()
    }

//        val user = intent.getStringExtra("EXTRA_USER")
//        val name = intent.getStringExtra("EXTRA_NAME")
//        val lastname = intent.getStringExtra("EXTRA_LASTNAME")
//        val mail = intent.getStringExtra("EXTRA_MAIL")
//        val sex = intent.getStringExtra("EXTRA_SEX")
//        val pass = intent.getStringExtra("EXTRA_PASS")
//
//        Toast.makeText(this, " $user, \n $name , $lastname \n $mail \n $sex \n $pass"
//            , Toast.LENGTH_LONG).show()
//
//        if (name.isNullOrBlank()) {
//            //binding.tvHome.text = "Usuario: $user, \n" +
//                    //"contraseña: $pass"
//        }else {
////            binding.tvHome.text = " Usuario: $user, \n" +
////                    "Nombre: $name , $lastname \n" +
////                    "Correo: $mail \n" +
////                    "Sexo: $sex \n" +
////                    "contraseña: $pass"
//        }



}



