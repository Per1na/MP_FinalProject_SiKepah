package com.example.mp_finalproject

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CreateDriverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createdriver)  // Layout Buat Akun Driver

        val backButton: ImageView = findViewById(R.id.back_button)
        backButton.setOnClickListener {
            // Kembali ke MainActivity
            val intent = Intent(this, MainActivity::class.java)
            // Menambahkan flag untuk menghapus aktivitas yang berada di atas MainActivity
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            // Menutup aktivitas ini agar tidak ada di stack
            finish()
        }

        // Referensi EditText
        val etUsernameDriver = findViewById<EditText>(R.id.etUsernameSupir)
        val etEmailDriver = findViewById<EditText>(R.id.etEmailSupir)
        val etKataSandiDriver = findViewById<EditText>(R.id.etKataSandiSupir)
        val buttonCreateDriver = findViewById<Button>(R.id.button_createSupir)
        val buttonMasukDriver = findViewById<Button>(R.id.btnMasuk)

        // Referensi ImageView untuk ikon show/hide password
        val showHidePasswordIcon: ImageView = findViewById(R.id.showHidePasswordIconDriver)

        // Flag untuk menentukan apakah password sedang disembunyikan atau ditampilkan
        var isPasswordVisible = false

        // Menangani aksi klik pada ikon show/hide password
        showHidePasswordIcon.setOnClickListener {
            if (isPasswordVisible) {
                // Jika password sedang ditampilkan, sembunyikan
                etKataSandiDriver.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                showHidePasswordIcon.setImageResource(R.drawable.hide_pelanggan)  // Ganti dengan ikon hide
            } else {
                // Jika password sedang disembunyikan, tampilkan
                etKataSandiDriver.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                showHidePasswordIcon.setImageResource(R.drawable.show_pelanggan)  // Ganti dengan ikon show
            }

            // Ubah flag status password visible
            isPasswordVisible = !isPasswordVisible

            // Memastikan kursor tetap di akhir teks setelah perubahan inputType
            etKataSandiDriver.setSelection(etKataSandiDriver.text.length)
        }

        // Tombol untuk registrasi
        buttonCreateDriver.setOnClickListener {

            // Validasi username
            val username = etUsernameDriver.text.toString().trim()
            if (username.isEmpty()) {
                etUsernameDriver.error = "Nama tidak boleh kosong"
                return@setOnClickListener
            }
            if (!username.matches(Regex("^[A-Za-z ]+$"))) {
                etUsernameDriver.error = "Nama hanya boleh mengandung huruf"
                return@setOnClickListener
            }

            // Validasi email
            val email = etEmailDriver.text.toString().trim()
            if (email.isEmpty()) {
                etEmailDriver.error = "Email tidak boleh kosong"
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmailDriver.error = "Format email tidak valid"
                return@setOnClickListener
            }

            // Validasi kata sandi
            val password = etKataSandiDriver.text.toString().trim()
            if (password.isEmpty()) {
                etKataSandiDriver.error = "Password tidak boleh kosong"
                return@setOnClickListener
            }
            if (password.length < 8) {
                etKataSandiDriver.error = "Password harus lebih dari 8 karakter"
                return@setOnClickListener
            }

            // Jika semua validasi berhasil
            Toast.makeText(this, "Registrasi berhasil", Toast.LENGTH_SHORT).show()

            // Lakukan aksi lebih lanjut, seperti menyimpan data atau navigasi ke aktivitas lain

            // Navigate to VerifikasiDriverActivity
            val intent = Intent(this, VerifikasiDriverActivity::class.java)
            startActivity(intent)
        }
        buttonMasukDriver.setOnClickListener {
            val intent = Intent(this, LoginDriverActivity::class.java)
            startActivity(intent)
        }
    }
}

