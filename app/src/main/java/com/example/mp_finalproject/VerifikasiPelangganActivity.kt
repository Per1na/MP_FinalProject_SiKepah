package com.example.mp_finalproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class VerifikasiPelangganActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verifikasipelanggan) // Layout Verifikasi Kode OTP Pelanggan

        val buttonVerifikasiPelanggan: Button = findViewById(R.id.button_VerifikasiPelanggan)

        val backButton: ImageView = findViewById(R.id.back_button)
        backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        buttonVerifikasiPelanggan.setOnClickListener {
         val intent = Intent(this, VerifikasiBerhasilActivity::class.java)
         startActivity(intent)
        }
    }
}