package com.example.mp_finalproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class RincianPenjemputanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rincianpenjemputan) // Sesuaikan nama layout Rincian Penjemputan

        val backButton: ImageView = findViewById(R.id.back_button)
        backButton.setOnClickListener {
            finish() // Closes the current activity (RincianPenjemputanActivity)
        }
        val btnMasuk: Button = findViewById(R.id.BtnMenu)
        btnMasuk.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }
    }
}