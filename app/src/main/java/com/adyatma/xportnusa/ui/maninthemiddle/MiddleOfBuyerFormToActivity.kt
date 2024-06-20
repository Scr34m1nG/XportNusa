package com.adyatma.xportnusa.ui.maninthemiddle

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.adyatma.xportnusa.R
import com.example.coba.DetailActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MiddleOfBuyerFormToActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_middle_of_buyer_form_to)

        lifecycleScope.launch {
            delay(1500)
            startActivity(Intent(this@MiddleOfBuyerFormToActivity, DetailActivity::class.java))
        }
    }
}