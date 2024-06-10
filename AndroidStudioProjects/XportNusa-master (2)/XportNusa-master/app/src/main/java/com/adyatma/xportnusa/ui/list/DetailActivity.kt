package com.adyatma.xportnusa.ui.list

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.adyatma.xportnusa.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

// Di dalam DetailActivity.kt
        val priceTextView: TextView = findViewById(R.id.customPrice)
        val produkDescriptionsTextView: TextView = findViewById(R.id.customProdukDescriptions)
        val produkDetailsTextView: TextView = findViewById(R.id.customProdukDetails)

        val price = "$35"
        val produkDetails = "Detail produk ini adalah..."
        val produkDescriptions = "Kopi merupakan sejenis minuman yang berasal dari proses pengolahan biji tanaman kopi. Kopi digolongkan ke dalam famili Rubiaceae dengan genus Coffea."

        priceTextView.text = price
        produkDescriptionsTextView.text = produkDescriptions
        produkDetailsTextView.text = produkDetails

        }
    }