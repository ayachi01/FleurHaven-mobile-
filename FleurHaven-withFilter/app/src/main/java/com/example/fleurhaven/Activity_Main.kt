package com.example.fleurhaven

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Activity_Main : AppCompatActivity() {

    private lateinit var cart_icon: ImageButton
    private lateinit var profile_icon: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.cart_icon = findViewById(R.id.cart_icon)
        cart_icon.setOnClickListener {
            val intent2 = Intent(this, Activity_Cart::class.java)
            startActivity(intent2)
        }


    }
}
