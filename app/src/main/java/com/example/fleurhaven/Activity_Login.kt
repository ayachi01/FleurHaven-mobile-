package com.example.fleurhaven

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Activity_Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // Get references to UI elements
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.submitBtn)
        val signUpText = findViewById<TextView>(R.id.signupText)

        // Handle "Sign Up" click event
        signUpText.setOnClickListener {
            startActivity(Intent(this, Activity_Signup::class.java)) // Open Signup Activity
        }

        // Handle "Login" button click
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim() // Get user email
            val password = passwordEditText.text.toString().trim() // Get user password

            // Validate inputs
            if (email.isEmpty()) {
                emailEditText.error = "Email is required"
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                passwordEditText.error = "Password is required"
                return@setOnClickListener
            }

            // Assuming successful login for now
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()

            // Navigate to Activity_Main
            val intent = Intent(this, Activity_Main::class.java)
            startActivity(intent)

        }



    }
}