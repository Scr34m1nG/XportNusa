package com.adyatma.xportnusa.ui.signup

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.adyatma.xportnusa.R
import com.adyatma.xportnusa.customview.EditTextEmail
import com.adyatma.xportnusa.customview.EditTextPassword
import com.adyatma.xportnusa.databinding.ActivitySignUpBinding
import com.adyatma.xportnusa.ui.formfieldform.BuyerOrSeller
import com.adyatma.xportnusa.ui.formfieldform.buyerform.BuyerFormActivity
import com.adyatma.xportnusa.ui.formfieldform.sellerform.SellerFormActivity
import com.adyatma.xportnusa.ui.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {
    private val binding: ActivitySignUpBinding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.signUpButton.setOnClickListener { 
            val username = binding.usernameEditText.text.toString()
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()

            if (validateInput(username, email, password )) {
                registerUser(username, email, password)
            }
            startActivity(Intent(this@SignUpActivity, BuyerFormActivity::class.java))
        }

        binding.gotoLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun validateInput(username: String, email: String, password: String): Boolean {
        if (TextUtils.isEmpty(username) && TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {
            Toast.makeText(this, "input data correctly", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    private fun registerUser(username: String, email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    saveUserData(user!!.uid, username, email)
                } else {
                    Toast.makeText(this, "registrastion Error", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun saveUserData(uid: String, username: String, email: String) {
        val db = FirebaseDatabase.getInstance().reference
        val user = db.child("users").child(uid)

        val userMap = hashMapOf(
            "username" to username,
            "email" to email,
        )

        user.setValue(userMap)
            .addOnSuccessListener {
                Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, BuyerOrSeller::class.java))
            }
    }
}