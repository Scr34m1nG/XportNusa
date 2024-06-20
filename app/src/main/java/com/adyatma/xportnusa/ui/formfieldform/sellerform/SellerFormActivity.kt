package com.adyatma.xportnusa.ui.formfieldform.sellerform

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.adyatma.xportnusa.R
import com.adyatma.xportnusa.databinding.ActivitySellerFormBinding
import com.adyatma.xportnusa.ui.maninthemiddle.MiddleOfSellerToActivity

class SellerFormActivity : AppCompatActivity() {
    private val binding: ActivitySellerFormBinding by lazy {
        ActivitySellerFormBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.buttonGotoMiddle.setOnClickListener {
            startActivity(Intent(this@SellerFormActivity, MiddleOfSellerToActivity::class.java))
        }
    }
}