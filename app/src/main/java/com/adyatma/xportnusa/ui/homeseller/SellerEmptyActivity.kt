package com.adyatma.xportnusa.ui.homeseller

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.credentials.ClearCredentialStateRequest
import androidx.credentials.CredentialManager
import androidx.lifecycle.lifecycleScope
import com.adyatma.xportnusa.R
import com.adyatma.xportnusa.databinding.ActivitySellerEmptyBinding
import com.adyatma.xportnusa.ui.login.LoginActivity
import com.adyatma.xportnusa.ui.upload.UploadActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch

class SellerEmptyActivity : AppCompatActivity() {
    private val binding: ActivitySellerEmptyBinding by lazy {
        ActivitySellerEmptyBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.fabAdd.setOnClickListener {
            startActivity(Intent(this@SellerEmptyActivity, UploadActivity::class.java))
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_option, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.sign_out -> {
                signOut()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun signOut() {
        lifecycleScope.launch {
            val credentialManager = CredentialManager.create(this@SellerEmptyActivity)

            val auth = Firebase.auth
            auth.signOut()
            credentialManager.clearCredentialState(ClearCredentialStateRequest())
            startActivity(Intent(this@SellerEmptyActivity, LoginActivity::class.java))

            finish()
        }
    }
}