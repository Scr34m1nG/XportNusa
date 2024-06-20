package com.adyatma.xportnusa.ui.maninthemiddle

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.adyatma.xportnusa.R
import com.adyatma.xportnusa.ui.homeseller.SellerEmptyActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MiddleOfSellerToActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_middle_of_seller_to)
        lifecycleScope.launch {
            delay(1500)
            startActivity(Intent(this@MiddleOfSellerToActivity, SellerEmptyActivity::class.java))
        }

    }
}