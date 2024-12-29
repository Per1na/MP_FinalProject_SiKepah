package com.example.mp_finalproject

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
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

            // Menangani Toggle Kata Sandi Driver
            val passwordEditTextSupir: EditText = findViewById(R.id.etKataSandiSupir)
            val togglePasswordImageViewSupir: ImageView = findViewById(R.id.TogglePasswordSupir)
            togglePasswordImageViewSupir.setOnClickListener {
                if (passwordEditTextSupir.transformationMethod == PasswordTransformationMethod.getInstance()) {
                    // Tampilkan Kata Sandi
                    passwordEditTextSupir.transformationMethod = HideReturnsTransformationMethod.getInstance()
                    togglePasswordImageViewSupir.setImageResource(R.drawable.show_supir) // Ganti dengan ikon untuk menampilkan password
                } else {
                    // Sembunyikan Kata Sandi
                    passwordEditTextSupir.transformationMethod = PasswordTransformationMethod.getInstance()
                    togglePasswordImageViewSupir.setImageResource(R.drawable.hide_supir) // Ganti dengan ikon untuk menyembunyikan password
                }
            }


            // Menangani 'Daftar' button untuk Driver
            val daftarButtonDriver: Button = findViewById(R.id.ellipse_button)
            daftarButtonDriver.setOnClickListener {
                val usernameDriver: String = findViewById<EditText>(R.id.etUsernameSupir).text.toString()
                val emailDriver: String = findViewById<EditText>(R.id.etEmailSupir).text.toString()
                val passwordDriver: String = passwordEditTextSupir.text.toString()

                if (usernameDriver.isNotEmpty() && emailDriver.isNotEmpty() && passwordDriver.isNotEmpty()) {
                    // Proses registrasi driver, misalnya mengirim data ke server atau menyimpannya
                    // Misalnya, bisa menampilkan pesan sukses
                    // Toast.makeText(this, "Registrasi berhasil", Toast.LENGTH_SHORT).show()
                } else {
                    // Tampilkan pesan kesalahan jika input tidak lengkap
                    // Toast.makeText(this, "Harap lengkapi semua kolom", Toast.LENGTH_SHORT).show()
                }
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

            // Menangani Button Kata Sandi Pelanggan
            val passwordEditTextPelanggan: EditText = findViewById(R.id.etKataSandiPelanggan)
            val togglePasswordImageViewPelanggan: ImageView = findViewById(R.id.TogglePasswordPelanggan)

            togglePasswordImageViewPelanggan.setOnClickListener {
                if (passwordEditTextPelanggan.transformationMethod == PasswordTransformationMethod.getInstance()) {
                    // Show Kata Sandi
                    passwordEditTextPelanggan.transformationMethod = HideReturnsTransformationMethod.getInstance()
                    togglePasswordImageViewPelanggan.setImageResource(R.drawable.show_pelanggan) // Ganti dengan ikon untuk menampilkan password
                } else {
                    // Hide Kata Sandi
                    passwordEditTextPelanggan.transformationMethod = PasswordTransformationMethod.getInstance()
                    togglePasswordImageViewPelanggan.setImageResource(R.drawable.hide_pelanggan) // Ganti dengan ikon untuk menyembunyikan password
                }
            }

            // Menangani 'Daftar' button
            val daftarButton: Button = findViewById(R.id.ellipse_button)
            daftarButton.setOnClickListener {
                val username: String = findViewById<EditText>(R.id.etUsernameSupir).text.toString()
                val email: String = findViewById<EditText>(R.id.etEmailSupir).text.toString()
                val password: String = passwordEditTextPelanggan.text.toString()

                if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                    // Proses registrasi pelanggan, misalnya mengirim data ke server atau menyimpannya
                    // Misalnya, bisa menampilkan pesan sukses
                    // Toast.makeText(this, "Registrasi berhasil", Toast.LENGTH_SHORT).show()
                } else {
                    // Tampilkan pesan kesalahan jika input tidak lengkap
                    // Toast.makeText(this, "Harap lengkapi semua kolom", Toast.LENGTH_SHORT).show()
                }
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
}


