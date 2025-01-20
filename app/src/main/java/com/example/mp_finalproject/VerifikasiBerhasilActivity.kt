package com.example.mp_finalproject


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class VerifikasiBerhasilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verifikasiberhasil) // Layout Verifikasi Berhasil

        // Navigasi dengan delay 3 detik
        lifecycleScope.launch {
            delay(3000) // Delay 3 detik
            navigateToNextScreen()
        }
    }

    private fun navigateToNextScreen() {
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
        finish() // Opsional, agar tidak kembali ke screen sebelumnya
    }
}