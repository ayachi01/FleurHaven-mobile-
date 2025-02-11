package com.example.fleurhaven

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity_Cart : AppCompatActivity() {

    private lateinit var cart_icon: ImageButton
    private lateinit var profile_icon: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)


        // Find the cart icon button
        this.profile_icon = findViewById(R.id.profile_icon)
        profile_icon.setOnClickListener {
            // Start Activity_Cart when cart icon is clicked
            val intent2 = Intent(this, Activity_Main::class.java)
            startActivity(intent2)
        }
        }

    }

