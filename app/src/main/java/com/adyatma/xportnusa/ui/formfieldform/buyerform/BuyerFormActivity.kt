package com.adyatma.xportnusa.ui.formfieldform.buyerform

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.adyatma.xportnusa.R
import com.adyatma.xportnusa.databinding.ActivityBuyerFormBinding
import com.adyatma.xportnusa.ui.maninthemiddle.MiddleOfBuyerFormToActivity

class BuyerFormActivity : AppCompatActivity() {
    private val binding: ActivityBuyerFormBinding by lazy {
        ActivityBuyerFormBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.submitButton.setOnClickListener { 
            startActivity(Intent(this@BuyerFormActivity, MiddleOfBuyerFormToActivity::class.java))
        }
    }
}