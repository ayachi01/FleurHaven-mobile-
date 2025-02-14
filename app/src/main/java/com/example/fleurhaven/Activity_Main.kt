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
            val intent = Intent(this, Activity_Login::class.java)
            startActivity(intent)
        }


    }
}