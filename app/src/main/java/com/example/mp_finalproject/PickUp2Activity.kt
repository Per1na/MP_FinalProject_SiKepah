package com.example.mp_finalproject

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class PickUp2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pickup2) // Menghubungkan ke layout activity_pickup2.xml

        // Button kembali
        val backButton: ImageView = findViewById(R.id.back_button)
        backButton.setOnClickListener {
            finish()
        }

        // Referensi EditText
        val etNamaLengkap = findViewById<EditText>(R.id.Nama_Lengkap)
        val etAlamatPickUp2 = findViewById<EditText>(R.id.Alamat_PickUp2)
        val etNoHpPickUp2 = findViewById<EditText>(R.id.NoHp_PickUp2)
        val buttonKonfirmasi = findViewById<Button>(R.id.KonfirmasiButton)

        // Tombol untuk konfirmasi
        buttonKonfirmasi.setOnClickListener {

            // Validasi username
            val username = etNamaLengkap.text.toString().trim()
            if (username.isEmpty()) {
                etNamaLengkap.error = "Nama tidak boleh kosong"
                return@setOnClickListener
            }
            if (!username.matches(Regex("^[A-Za-z ]+$"))) {
                etNamaLengkap.error = "Nama hanya boleh mengandung huruf"
                return@setOnClickListener
            }

            // Validasi Alamat Pick Up
            val alamatPickUp = etAlamatPickUp2.text.toString().trim()
            if (alamatPickUp.isEmpty()) {
                etAlamatPickUp2.error = "Alamat PickUp tidak boleh kosong"
                return@setOnClickListener
            }

            // Validasi Nomor HP
            val noHpPickUp = etNoHpPickUp2.text.toString().trim()
            if (noHpPickUp.isEmpty()) {
                etNoHpPickUp2.error = "Nomor HP tidak boleh kosong"
                return@setOnClickListener
            }
            if (!Patterns.PHONE.matcher(noHpPickUp).matches()) {
                etNoHpPickUp2.error = "Format nomor HP tidak valid"
                return@setOnClickListener
            }

            // Jika semua validasi berhasil, tampilkan dialog konfirmasi
            val alertDialog = AlertDialog.Builder(this)
                .setTitle("Konfirmasi")
                .setMessage("Informasi yang diisi sudah benar?")
                .setPositiveButton("Konfirmasi") { dialog, which ->
                    // Jika pengguna memilih Konfirmasi, lanjutkan ke aktivitas berikutnya
                    Toast.makeText(this, "Konfirmasi Berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, RincianPenjemputanActivity::class.java)
                    startActivity(intent)
                }
                .setNegativeButton("Kembali") { dialog, which ->
                    // Jika pengguna memilih Kembali, dialog ditutup dan tidak melakukan tindakan
                    dialog.dismiss()
                }
                .create()

            // Tampilkan dialog
            alertDialog.show()
        }
    }
}


