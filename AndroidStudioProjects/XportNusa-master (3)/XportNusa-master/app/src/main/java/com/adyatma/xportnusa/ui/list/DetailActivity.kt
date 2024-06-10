package com.example.coba

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.adyatma.xportnusa.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Enable edge-to-edge display
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Inisialisasi TextView
        val priceTextView: TextView = findViewById(R.id.customPrice)
        val produkDescriptionsTextView: TextView = findViewById(R.id.customProdukDescriptions)
        val produkDetailsTextView: TextView = findViewById(R.id.customProdukDetails)

        // Mendapatkan data dari intent
        val productName = intent.getStringExtra("productName")

        // Set teks pada TextView berdasarkan produk yang dipilih
        when (productName) {
            "Coffee" -> {
                supportActionBar?.title = "Detail Produk Coffee"
                val coffeeProdukDetails = "Detail produk coffee ini adalah..."
                val coffeeProdukDescriptions = "Coffee adalah minuman yang berasal dari biji kopi yang diolah dengan berbagai cara, seperti diseduh atau dituang air panas. Minuman ini memiliki berbagai varietas dan cita rasa yang khas."
                produkDetailsTextView.text = coffeeProdukDetails
                produkDescriptionsTextView.text = coffeeProdukDescriptions
            }
            "Cacao" -> {
                supportActionBar?.title = "Detail Produk Cacao"
                val cacaoProdukDetails = "Detail produk cacao ini adalah..."
                val cacaoProdukDescriptions = "Cacao merupakan biji tanaman kakao yang digunakan untuk membuat cokelat. Kakao memiliki cita rasa yang khas dan digunakan dalam berbagai produk makanan dan minuman."
                produkDetailsTextView.text = cacaoProdukDetails
                produkDescriptionsTextView.text = cacaoProdukDescriptions
            }
            "Wood" -> {
                supportActionBar?.title = "Detail Produk Wood"
                val woodProdukDetails = "Detail produk wood ini adalah..."
                val woodProdukDescriptions = "Wood adalah jenis kayu yang digunakan dalam berbagai industri. Kayu ini memiliki kekuatan dan keawetan yang baik, sehingga sering digunakan dalam konstruksi dan pembuatan perabotan."
                produkDetailsTextView.text = woodProdukDetails
                produkDescriptionsTextView.text = woodProdukDescriptions
            }
        }

        // Set teks pada TextView harga
        val price = "$35"
        priceTextView.text = price
    }
}