package com.example.mp_finalproject.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mp_finalproject.PickUp2Activity
import com.example.mp_finalproject.R

class PickupFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_pickup, container, false)

        // Initialize the checkboxes
        val checkBoxPlastik: CheckBox = rootView.findViewById(R.id.CheckBoxPlastik)
        val checkBoxKertasKardus: CheckBox = rootView.findViewById(R.id.CheckBoxKertas_Kardus)
        val checkBoxLogam: CheckBox = rootView.findViewById(R.id.CheckBoxLogam)
        val checkBoxKaca: CheckBox = rootView.findViewById(R.id.CheckBoxKaca)
        val checkBoxElektronik: CheckBox = rootView.findViewById(R.id.CheckBoxElektronik)

        // Tombol Lanjut
        val nextButton: Button = rootView.findViewById(R.id.nextButton)

        // Logic to handle checkbox changes
        val selectedWasteTypes = mutableListOf<String>()

        // Handle Plastik CheckBox change
        checkBoxPlastik.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                if (!selectedWasteTypes.contains("Plastik")) {
                    selectedWasteTypes.add("Plastik")
                }
            } else {
                selectedWasteTypes.remove("Plastik")
            }
        }

        // Handle Kertas/Kardus CheckBox change
        checkBoxKertasKardus.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                if (!selectedWasteTypes.contains("Kertas/Kardus")) {
                    selectedWasteTypes.add("Kertas/Kardus")
                }
            } else {
                selectedWasteTypes.remove("Kertas/Kardus")
            }
        }

        // Handle Logam CheckBox change
        checkBoxLogam.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                if (!selectedWasteTypes.contains("Logam")) {
                    selectedWasteTypes.add("Logam")
                }
            } else {
                selectedWasteTypes.remove("Logam")
            }
        }

        // Handle Kaca CheckBox change
        checkBoxKaca.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                if (!selectedWasteTypes.contains("Kaca")) {
                    selectedWasteTypes.add("Kaca")
                }
            } else {
                selectedWasteTypes.remove("Kaca")
            }
        }

        // Handle Elektronik CheckBox change
        checkBoxElektronik.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                if (!selectedWasteTypes.contains("Elektronik")) {
                    selectedWasteTypes.add("Elektronik")
                }
            } else {
                selectedWasteTypes.remove("Elektronik")
            }
        }

        // Logic for the "Lanjut" button
        nextButton.setOnClickListener {

            val inputBeratSampah = rootView.findViewById<EditText>(R.id.inputWeight)

            val sampahBerat = inputBeratSampah.text.toString().trim()
            if (sampahBerat.isEmpty()) {
                inputBeratSampah.error = "Berat sampah tidak boleh kosong"
                return@setOnClickListener
            }

            // Check if no item is selected
            if (selectedWasteTypes.isEmpty()) {
                // Show a message if no waste type is selected
                Toast.makeText(context, "Kamu belum memilih jenis sampah", Toast.LENGTH_SHORT).show()
            } else {
                // Navigate to PickUp2Activity
                val intent = Intent(requireContext(), PickUp2Activity::class.java)
                startActivity(intent)

                // Optionally, show the selected waste types in the next activity or log it
                Toast.makeText(context, "Selected waste types: $selectedWasteTypes", Toast.LENGTH_SHORT).show()
            }
        }
        return rootView
    }
}
