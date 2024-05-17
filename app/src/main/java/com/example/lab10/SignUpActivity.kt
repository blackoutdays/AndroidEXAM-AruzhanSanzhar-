package com.example.lab10

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lab10.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signupbtn.setOnClickListener {
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()
            val passwordCopy = binding.passwordCopy.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty() && password == passwordCopy) {
                Toast.makeText(this, "Sign up successful!", Toast.LENGTH_SHORT).show()
                binding.signupbtn.setOnClickListener {
                    navigateToMainActivity()
                }
            } else {
                Toast.makeText(this, "Passwords do not match or fields are empty!", Toast.LENGTH_SHORT).show()
            }
        }

        // Add click listener to the "Sign up" button

    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Finish the sign-up activity so the user cannot go back to it
    }
}
