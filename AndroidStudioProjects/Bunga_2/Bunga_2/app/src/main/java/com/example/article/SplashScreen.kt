package com.example.article

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            // Intent untuk memulai layar utama
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Menutup activity splash screen agar tidak dapat diakses kembali
        }, 2000)
    }
}