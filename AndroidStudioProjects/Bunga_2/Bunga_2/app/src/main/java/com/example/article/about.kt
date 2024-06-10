package com.example.article

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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