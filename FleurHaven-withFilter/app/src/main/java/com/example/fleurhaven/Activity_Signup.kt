package com.example.fleurhaven

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Activity_Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // Get references to UI elements
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val usernameEditText = findViewById<EditText>(R.id.usernEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val passwordConfEditText = findViewById<EditText>(R.id.passwconfEditText)
        val submitButton = findViewById<Button>(R.id.submitBtn)

        submitButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val username = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val passwordConf = passwordConfEditText.text.toString().trim()

            // Validate inputs
            if (email.isEmpty()) {
                emailEditText.error = "Email is required"
                return@setOnClickListener
            }
            if (username.isEmpty()) {
                usernameEditText.error = "Username is required"
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                passwordEditText.error = "Password is required"
                return@setOnClickListener
            }
            if (passwordConf.isEmpty()) {
                passwordConfEditText.error = "Password confirmation is required"
                return@setOnClickListener
            }
            if (password != passwordConf) {
                passwordConfEditText.error = "Passwords do not match"
                return@setOnClickListener
            }

            // Proceed with signup logic (e.g., saving to database)
            Toast.makeText(this, "Signup successful", Toast.LENGTH_SHORT).show()

            // Redirect to Login
            val intent = Intent(this, Activity_Login::class.java)
            startActivity(intent)
            finish()
        }
    }
}