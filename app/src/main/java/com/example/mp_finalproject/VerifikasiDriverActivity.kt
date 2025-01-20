package com.example.mp_finalproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class VerifikasiDriverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verifikasidriver) // Layout Verifikasi Kode OTP Driver

        val buttonVerifikasiDriver: Button = findViewById(R.id.button_VerifikasiDriver)

        val backButton: ImageView = findViewById(R.id.back_button)
        backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        buttonVerifikasiDriver.setOnClickListener {
            val intent = Intent(this, VerifikasiBerhasilActivity::class.java)
            startActivity(intent)
        }
    }
}