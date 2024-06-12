package com.adyatma.xportnusa.ui.branch

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.adyatma.xportnusa.R
import com.adyatma.xportnusa.databinding.ActivityBranchBinding
import com.adyatma.xportnusa.ui.login.LoginActivity
import com.adyatma.xportnusa.ui.login.LoginSellerActivity

class BranchActivity : AppCompatActivity() {
    private val binding: ActivityBranchBinding by lazy {
        ActivityBranchBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.buttonBuyer.setOnClickListener {
            startActivity(Intent(this@BranchActivity, LoginActivity::class.java))
        }

        binding.buttonSeller.setOnClickListener {
            startActivity(Intent(this@BranchActivity, LoginSellerActivity::class.java))
        }
    }
}