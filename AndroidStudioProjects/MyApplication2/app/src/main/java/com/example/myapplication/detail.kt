package com.example.article

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R

class detail : AppCompatActivity() {
    private lateinit var nama: TextView
    private lateinit var description: TextView
    private lateinit var img: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bundle: Bundle? = intent.extras
        val nama = bundle?.getString("nama")
        val description = bundle?.getString("deskripsi")
        val img = bundle?.getInt("img")

        this.nama = findViewById(R.id.nama_detail)
        this.description = findViewById(R.id.deskripsi_detail)
        this.img = findViewById(R.id.gambar_detail)

        this.nama.text = nama
        this.description.text = description
        this.img.setImageResource(img ?: R.drawable.ic_launcher_background)

        findViewById<Button>(R.id.action_share).setOnClickListener {
            val link = "https://www.linkedin.com/in/kensa-marsela-kelin-162369240?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app"  // Replace with your actual link

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"  // This specifies the type of content being shared (plain text with the link)
            intent.putExtra(Intent.EXTRA_TEXT, link)  // Add the link to the intent

            // Optionally, set a sharing title (if supported by the receiving app)
            intent.putExtra(Intent.EXTRA_TITLE, "Share link")

            startActivity(Intent.createChooser(intent, "Share Link"))
        }
    }
}