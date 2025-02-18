package com.example.fleurhaven

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Activity_Main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cartIcon = findViewById<ImageButton>(R.id.cart_icon)
        val profileIcon = findViewById<ImageButton>(R.id.profile_icon)

        cartIcon.setOnClickListener {
            val intent = Intent(this, Activity_Cart::class.java)
            startActivity(intent)
        }

        profileIcon.setOnClickListener {
            // Retrieve user data (to check if they are logged in)
            val sharedPref = getSharedPreferences("user_data", MODE_PRIVATE)
            val storedEmail = sharedPref.getString("email", null)

            // If the user is logged in, show their profile, otherwise, redirect to login
            if (storedEmail != null) {
                val intent = Intent(this, Activity_Profile::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, Activity_Login::class.java)
                startActivity(intent)
            }
        }


    }
}