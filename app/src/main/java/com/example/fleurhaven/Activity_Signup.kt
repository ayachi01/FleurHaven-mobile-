package com.example.fleurhaven

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Activity_Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // Get references to UI elements
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val passwordConfEditText = findViewById<EditText>(R.id.passwconfEditText)
        val submitButton = findViewById<Button>(R.id.submitBtn)

        submitButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val passwordConf = passwordConfEditText.text.toString().trim()

            // Collect error messages
            val errorMessages = mutableListOf<String>()

            // Validate inputs
            if (email.isEmpty()) {
                emailEditText.error = "Email is required"
                errorMessages.add("Email is required")
            }
            // Check email format (@gmail.com)
            if (!email.endsWith("@gmail.com")) {
                emailEditText.error = "Invalid email address"
                errorMessages.add("Invalid email address")
            }

            if (password.isEmpty()) {
                passwordEditText.error = "Password is required"
                errorMessages.add("Password is required")
            }
            // Check password length
            if (password.length < 8) {
                passwordEditText.error = "Password must be at least 8 characters"
                errorMessages.add("Password must be at least 8 characters")
            }
            if (passwordConf.isEmpty()) {
                passwordConfEditText.error = "Password confirmation is required"
                errorMessages.add("Password confirmation is required")
            }
            if (password != passwordConf) {
                passwordConfEditText.error = "Passwords do not match"
                errorMessages.add("Passwords do not match")
            }

            // If there are any error messages, show them
            if (errorMessages.isNotEmpty()) {
                Toast.makeText(this, errorMessages.joinToString("\n"), Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            // Proceed with signup logic (e.g., saving to database)
            Toast.makeText(this, "Signup successful", Toast.LENGTH_SHORT).show()

            // Redirect to Login8
            val intent = Intent(this, Activity_Login::class.java)
            startActivity(intent)
            finish()
        }
    }
}