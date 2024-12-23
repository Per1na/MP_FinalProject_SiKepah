package com.example.mp_finalproject

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.tampilan_awal)

        setupBackButtonListeners()

        val btnDriver: Button = findViewById(R.id.driverButton)
        btnDriver.setOnClickListener {
            setContentView(R.layout.buat_akun_driver)

            val backButtonDriver: ImageView = findViewById(R.id.back_button)
            backButtonDriver.setOnClickListener {
                setContentView(R.layout.tampilan_awal)
                setupBackButtonListeners()
            }
        }

        val btnPelanggan: Button = findViewById(R.id.pelangganButton)
        btnPelanggan.setOnClickListener {
            setContentView(R.layout.buat_akun_pelanggan)

            val backButtonPelanggan: ImageView = findViewById(R.id.back_button)
            backButtonPelanggan.setOnClickListener {
                setContentView(R.layout.tampilan_awal)
                setupBackButtonListeners()
            }
        }
    }

    private fun setupBackButtonListeners() {
        val btnDriver: Button = findViewById(R.id.driverButton)
        btnDriver.setOnClickListener {
            setContentView(R.layout.buat_akun_driver)

            val backButtonDriver: ImageView = findViewById(R.id.back_button)
            backButtonDriver.setOnClickListener {
                setContentView(R.layout.tampilan_awal)
                setupBackButtonListeners()
            }
        }

        val btnPelanggan: Button = findViewById(R.id.pelangganButton)
        btnPelanggan.setOnClickListener {
            setContentView(R.layout.buat_akun_pelanggan)

            val backButtonPelanggan: ImageView = findViewById(R.id.back_button)
            backButtonPelanggan.setOnClickListener {
                setContentView(R.layout.tampilan_awal)
                setupBackButtonListeners()
            }
        }
    }
}
