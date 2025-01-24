package com.example.mp_finalproject


import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginPelangganActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginpelanggan) // Layout Masuk Akun Pelanggan

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
        val etEmailPelanggan = findViewById<EditText>(R.id.etEmailPelanggan)
        val etKataSandiPelanggan = findViewById<EditText>(R.id.etKataSandiPelanggan)
        val buttonMasukPelanggan = findViewById<Button>(R.id.button_masukpelanggan)
        val buttonCreateAccountPelanggan = findViewById<Button>(R.id.BuatAkunPelanggan)

        // Referensi ImageView untuk ikon show/hide password
        val showHidePasswordIcon: ImageView = findViewById(R.id.showHidePasswordIconPelanggan)

        // Flag untuk menentukan apakah password sedang disembunyikan atau ditampilkan
        var isPasswordVisible = false

        // Menangani aksi klik pada ikon show/hide password
        showHidePasswordIcon.setOnClickListener {
            if (isPasswordVisible) {
                // Jika password sedang ditampilkan, sembunyikan
                etKataSandiPelanggan.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                showHidePasswordIcon.setImageResource(R.drawable.hide_pelanggan)  // Ganti dengan ikon hide
            } else {
                // Jika password sedang disembunyikan, tampilkan
                etKataSandiPelanggan.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                showHidePasswordIcon.setImageResource(R.drawable.show_pelanggan)  // Ganti dengan ikon show
            }

            // Ubah flag status password visible
            isPasswordVisible = !isPasswordVisible

            // Memastikan kursor tetap di akhir teks setelah perubahan inputType
            etKataSandiPelanggan.setSelection(etKataSandiPelanggan.text.length)
        }
        // Tombol untuk registrasi
        buttonMasukPelanggan.setOnClickListener {

            // Validasi email
            val email = etEmailPelanggan.text.toString().trim()
            if (email.isEmpty()) {
                etEmailPelanggan.error = "Email tidak boleh kosong"
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmailPelanggan.error = "Format email tidak valid"
                return@setOnClickListener
            }

            // Validasi kata sandi
            val password = etKataSandiPelanggan.text.toString().trim()
            if (password.isEmpty()) {
                etKataSandiPelanggan.error = "Password tidak boleh kosong"
                return@setOnClickListener
            }
            if (password.length < 8) {
                etKataSandiPelanggan.error = "Password harus lebih dari 8 karakter"
                return@setOnClickListener
            }

            // Jika semua validasi berhasil
            Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
        }
        buttonCreateAccountPelanggan.setOnClickListener {
            val intent = Intent(this, CreatePelangganActivity::class.java)
            startActivity(intent)
        }
        // Tambahkan ini untuk navigasi ke activity_lupakatasandi
        val etLupaPasswordPelanggan = findViewById<TextView>(R.id.etLupaPasswordPelanggan)
        etLupaPasswordPelanggan.setOnClickListener {
            val intent = Intent(this, LupaSandiActivity::class.java)
            startActivity(intent)
        }
    }
}