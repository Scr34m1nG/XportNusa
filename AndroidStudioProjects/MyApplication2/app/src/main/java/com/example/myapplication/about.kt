package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class about : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val nama = findViewById<TextView>(R.id.nama_profile)
        val email = findViewById<TextView>(R.id.email)

        nama.text = "Kensa Marsela Kelin"
        email.text = "a728d4kx3722@bangkit.academy"
    }
}