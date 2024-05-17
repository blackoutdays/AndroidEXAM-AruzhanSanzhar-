package com.example.lab10

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab10.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginbtn.setOnClickListener {
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()

            // For simplicity, let's assume the login is successful if both fields are not empty
            if (username.isNotEmpty() && password.isNotEmpty()) {
                navigateToMainActivity()
            } else {
                // Handle login failure, e.g., show an error message
            }
        }
        binding.signupbtn.setOnClickListener {
            navigateToSignUpActivity()
        }
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Finish the login activity so the user cannot go back to it
    }
    private fun navigateToSignUpActivity() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }
}
