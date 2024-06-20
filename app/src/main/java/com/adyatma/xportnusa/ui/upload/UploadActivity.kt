package com.adyatma.xportnusa.ui.upload

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.adyatma.xportnusa.R
import com.adyatma.xportnusa.databinding.ActivityUploadBinding
import com.adyatma.xportnusa.ui.homeseller.SellerWithItemActivity

class UploadActivity : AppCompatActivity() {
    private val binding: ActivityUploadBinding by lazy {
        ActivityUploadBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.postButton.setOnClickListener {
            startActivity(Intent(this, SellerWithItemActivity::class.java))
        }
    }
}