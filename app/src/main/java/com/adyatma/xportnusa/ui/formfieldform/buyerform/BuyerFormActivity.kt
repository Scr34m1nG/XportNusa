package com.adyatma.xportnusa.ui.formfieldform.buyerform

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
import com.adyatma.xportnusa.databinding.ActivityBuyerFormBinding
import com.adyatma.xportnusa.ui.branch.BranchActivity
import com.adyatma.xportnusa.ui.login.LoginActivity
import com.adyatma.xportnusa.ui.maninthemiddle.MiddleOfBuyerFormToActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch

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
            val credentialManager = CredentialManager.create(this@BuyerFormActivity)

            val auth = Firebase.auth
            auth.signOut()
            credentialManager.clearCredentialState(ClearCredentialStateRequest())
            startActivity(Intent(this@BuyerFormActivity, BranchActivity::class.java))

            finish()
        }
    }
}