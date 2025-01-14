package com.example.mp_finalproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tampilan_awal)  // Layout utama

        // Navigasi ke activity_createpelanggan
        findViewById<View>(R.id.PelangganButton).setOnClickListener {
            val intent = Intent(this, CreatePelangganActivity::class.java)
            startActivity(intent)
        }

        // Navigasi ke activity_createdriver
        findViewById<View>(R.id.DriverButton).setOnClickListener {
            val intent = Intent(this, CreateDriverActivity::class.java)
            startActivity(intent)
        }
    }
}

