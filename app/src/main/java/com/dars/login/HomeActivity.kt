package com.dars.login

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dars.login.Constants.Companion.key_familiya
import com.dars.login.Constants.Companion.key_ism
import com.dars.login.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferences = getSharedPreferences(Constants.baza, MODE_PRIVATE)

        val ism=preferences.getString(key_ism,null)
        val fam=preferences.getString(key_familiya,null)

        binding.txtIsm.text=ism
        binding.txtfamiliya.text=fam
    }
}