package com.dars.login

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.dars.login.Constants.Companion.baza
import com.dars.login.Constants.Companion.key_familiya
import com.dars.login.Constants.Companion.key_ism
import com.dars.login.Constants.Companion.key_login
import com.dars.login.Constants.Companion.key_parol
import com.dars.login.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    lateinit var preference: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preference = getSharedPreferences(baza, MODE_PRIVATE)
        binding.btnRergister.setOnClickListener {
            val ism = binding.edIsm.text.toString()
            val fam = binding.edFamiliya.text.toString()
            val login = binding.edLogin.text.toString()
            val parol = binding.edParol.text.toString()
            if (ism.isNullOrEmpty()) {
                binding.edIsm.hint = "Ismingizni kiriting..."
                binding.edIsm.setHintTextColor(ContextCompat.getColor(this, R.color.red))
            } else if (fam.isNullOrEmpty()) {
                binding.edFamiliya.hint = "Familyangizni kiriting..."
                binding.edFamiliya.setHintTextColor(ContextCompat.getColor(this, R.color.red))
            } else if (login.isNullOrEmpty()) {
                binding.edLogin.hint = "Loginni kiriting..."
                binding.edLogin.setHintTextColor(ContextCompat.getColor(this, R.color.red))
            } else if (parol.isNullOrEmpty()) {
                binding.edParol.hint = "Parolni kiriting..."
                binding.edParol.setHintTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                saveUser(ism,fam,login,parol)
                finish()
            }
        }
    }


    fun saveUser(ism: String, familiya: String, login: String, parol: String) {
        val myEdit: SharedPreferences.Editor = preference.edit()
        myEdit.putString(key_ism, ism)
        myEdit.putString(key_familiya, familiya)
        myEdit.putString(key_login, login)
        myEdit.putString(key_parol, parol)
        myEdit.apply()
    }
}