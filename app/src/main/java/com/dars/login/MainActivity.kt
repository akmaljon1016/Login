package com.dars.login

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.dars.login.Constants.Companion.baza
import com.dars.login.Constants.Companion.key_login
import com.dars.login.Constants.Companion.key_parol
import com.dars.login.Constants.Companion.signIn
import com.dars.login.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferences = getSharedPreferences(baza, MODE_PRIVATE)
        if (getSignIn()) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        binding.txtRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignIn.setOnClickListener {
            val login = binding.edLogin.text.toString()
            val parol = binding.edParol.text.toString()
            if (login.isNullOrEmpty()) {
                binding.edLogin.hint = "Login empty..."
                binding.edLogin.setHintTextColor(ContextCompat.getColor(this, R.color.red))
            } else if (parol.isNullOrEmpty()) {
                binding.edParol.hint = "Parolni empty..."
                binding.edParol.setHintTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                val savedLogin = preferences.getString(key_login, null)
                val savedParol = preferences.getString(key_parol, null)
                if (login.equals(savedLogin) && parol.equals(savedParol)) {
                    signIn(true)
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }

    fun signIn(loggerOrNot: Boolean) {
        val myEdit: SharedPreferences.Editor = preferences.edit()
        myEdit.putBoolean(signIn, loggerOrNot)
        myEdit.apply()
    }

    fun getSignIn(): Boolean {
        val signIn = preferences.getBoolean(signIn, false)
        return signIn
    }
}