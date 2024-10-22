package com.example.group5_fitmeal

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var usernameInput: EditText
    private lateinit var mobileNumberInput: EditText
    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var registerButton: Button
    private lateinit var googleSignInButton: ImageView
    private lateinit var loginLink: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_page)

        // Menghubungkan view dengan id dari XML
        usernameInput = findViewById(R.id.usernameInput)
        mobileNumberInput = findViewById(R.id.mobileNumberInput)
        emailInput = findViewById(R.id.emailRegisterInput)
        passwordInput = findViewById(R.id.passwordRegisterInput)
        registerButton = findViewById(R.id.registerButton)
        googleSignInButton = findViewById(R.id.googleSignInButton)
        loginLink = findViewById(R.id.loginTextView)

        // Tombol Register
        registerButton.setOnClickListener {
            val username = usernameInput.text.toString().trim()
            val mobileNumber = mobileNumberInput.text.toString().trim()
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            // Validasi input
            if (TextUtils.isEmpty(username)) {
                usernameInput.error = "Please enter username"
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(mobileNumber)) {
                mobileNumberInput.error = "Please enter mobile number"
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(email)) {
                emailInput.error = "Please enter email"
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(password)) {
                passwordInput.error = "Please enter password"
                return@setOnClickListener
            }

            // Jika semua validasi lolos, tampilkan pesan sukses (atau integrasi lebih lanjut)
            Toast.makeText(this, "Registration Successful!", Toast.LENGTH_LONG).show()
            // Di sini, Anda bisa menambahkan integrasi ke Firebase atau server backend
        }

        // Tombol Google Sign-In (Tambahkan fungsi sesuai kebutuhan)
        googleSignInButton.setOnClickListener {
            Toast.makeText(this, "Google Sign-In Clicked", Toast.LENGTH_SHORT).show()
            // Di sini, Anda bisa menambahkan integrasi Google Sign-In
        }

        // Link Login untuk pengguna yang sudah punya akun
        loginLink.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}