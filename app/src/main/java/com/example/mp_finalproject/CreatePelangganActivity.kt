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

class CreatePelangganActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createpelanggan)  // Layout Buat Akun pelanggan

        val backButton: ImageView = findViewById(R.id.back_button)
        backButton.setOnClickListener {
            // Menggunakan Intent untuk kembali ke MainActivity
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP // Menambahkan flag untuk menghapus aktivitas yang berada di atas MainActivity
            startActivity(intent)
            finish() // Menutup aktivitas ini agar tidak ada di stack
        }


        // Referensi EditText
        val etUsernamePelanggan = findViewById<EditText>(R.id.etUsernamePelanggan)
        val etEmailPelanggan = findViewById<EditText>(R.id.etEmailPelanggan)
        val etKataSandiPelanggan = findViewById<EditText>(R.id.etKataSandiPelanggan)
        val buttonCreatePelanggan = findViewById<Button>(R.id.button_createPelanggan)
        val buttonMasukPelanggan = findViewById<Button>(R.id.teks_kanan)

        // Referensi ImageView untuk ikon show/hide password
        val showHidePasswordIcon: ImageView = findViewById(R.id.showHidePasswordIcon)

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
        buttonCreatePelanggan.setOnClickListener {

            // Validasi username
            val username = etUsernamePelanggan.text.toString().trim()
            if (username.isEmpty()) {
                etUsernamePelanggan.error = "Nama tidak boleh kosong"
                return@setOnClickListener
            }
            if (!username.matches(Regex("^[A-Za-z ]+$"))) {
                etUsernamePelanggan.error = "Nama hanya boleh mengandung huruf"
                return@setOnClickListener
            }

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
            Toast.makeText(this, "Registrasi berhasil", Toast.LENGTH_SHORT).show()

            // Lakukan aksi lebih lanjut, seperti menyimpan data atau navigasi ke aktivitas lain

            // Navigate to VerifikasiPelangganActivity
            val intent = Intent(this, VerifikasiPelangganActivity::class.java)
            startActivity(intent)
        }

        buttonMasukPelanggan.setOnClickListener {
            val intent = Intent(this, LoginPelangganActivity::class.java)
            startActivity(intent)
        }
    }
}
