package com.example.mp_finalproject

import android.os.Bundle
import android.text.InputType
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
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

            // Menambahkan show/hide password untuk Driver
            val etKataSandiSupir = findViewById<EditText>(R.id.etKataSandiSupir)
            etKataSandiSupir.setOnTouchListener { _, event ->
                if (event.action == MotionEvent.ACTION_UP) {
                    val drawableRight = etKataSandiSupir.compoundDrawables[2]  // drawableEnd
                    if (event.x >= (etKataSandiSupir.right - drawableRight.bounds.width())) {
                        togglePasswordVisibility(etKataSandiSupir)
                        it.performClick() // Memanggil performClick untuk aksesibilitas
                        return@setOnTouchListener true
                    }
                }
                false
            }
        }

        val btnPelanggan: Button = findViewById(R.id.pelangganButton)
        btnPelanggan.setOnClickListener {
            setContentView(R.layout.buat_akun_pelanggan_coba)

            val backButtonPelanggan: ImageView = findViewById(R.id.back_button)
            backButtonPelanggan.setOnClickListener {
                setContentView(R.layout.tampilan_awal)
                setupBackButtonListeners()
            }

            // Menambahkan show/hide password untuk Pelanggan
            val etKataSandiPelanggan = findViewById<EditText>(R.id.etKataSandiPelanggan)
            etKataSandiPelanggan.setOnTouchListener { _, event ->
                if (event.action == MotionEvent.ACTION_UP) {
                    val drawableRight = etKataSandiPelanggan.compoundDrawables[2]  // drawableEnd
                    if (event.x >= (etKataSandiPelanggan.right - drawableRight.bounds.width())) {
                        togglePasswordVisibility(etKataSandiPelanggan)
                        it.performClick() // Memanggil performClick untuk aksesibilitas
                        return@setOnTouchListener true
                    }
                }
                false
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
            setContentView(R.layout.buat_akun_pelanggan_coba)
            val backButtonPelanggan: ImageView = findViewById(R.id.back_button)
            backButtonPelanggan.setOnClickListener {
                setContentView(R.layout.tampilan_awal)
                setupBackButtonListeners()
            }
        }
    }

    private fun togglePasswordVisibility(editText: EditText) {
        val isPasswordVisible = editText.inputType == InputType.TYPE_TEXT_VARIATION_PASSWORD
        val newInputType = if (isPasswordVisible) {
            InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
        } else {
            InputType.TYPE_TEXT_VARIATION_PASSWORD
        }
        editText.inputType = newInputType
        editText.setSelection(editText.text.length)

        // Toggle the drawable icon (show/hide password)
        val drawable = if (isPasswordVisible) {
            R.drawable.hide_pelanggan  // Ganti dengan drawable hide
        } else {
            R.drawable.show_pelanggan // Ganti dengan drawable show
        }
        editText.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawable, 0)
    }
}
