
package com.example.fleurhaven

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Activity_Login : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Get references to UI elements
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginBtn)
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
            // Check email format (@gmail.com)
            if (!email.endsWith("@gmail.com")) {
                Toast.makeText(this, "Incorrect Email Format", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                passwordEditText.error = "Password is required"
                return@setOnClickListener
            }

            // Retrieve stored email and password from SharedPreferences
            val sharedPref = getSharedPreferences("user_data", MODE_PRIVATE)
            val storedEmail = sharedPref.getString("email", null)
            val storedPassword = sharedPref.getString("password", null)

            // Check if the entered credentials match the stored ones
            if (email == storedEmail && password == storedPassword) {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()

                // Navigate to Activity_Main if login is successful
                val intent = Intent(this, Activity_Main::class.java)
                startActivity(intent)
                finish() // Close the Login Activity
            } else {
                // If credentials do not match, show error
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}