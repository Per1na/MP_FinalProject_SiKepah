package com.example.mp_finalproject.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mp_finalproject.ProfilPelangganActivity
import com.example.mp_finalproject.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        // Temukan view ivProfile
        val ivProfile: ImageView = rootView.findViewById(R.id.ivProfile)

        // Set OnClickListener untuk ivProfile
        ivProfile.setOnClickListener {
            // Lakukan tindakan ketika tombol profil diklik
            // Contoh: navigasi ke ProfileActivity
            val intent = Intent(requireContext(), ProfilPelangganActivity::class.java)
            startActivity(intent)

            // Opsional: tampilkan pesan kepada pengguna
            Toast.makeText(requireContext(), "Navigasi ke Profil", Toast.LENGTH_SHORT).show()
        }

        return rootView
    }
}
