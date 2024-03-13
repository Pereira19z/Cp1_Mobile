package com.example.cp1_mobile

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var radioMale: RadioButton? = null
    private var radioFemale: RadioButton? = null
    private var editHeight: EditText? = null
    private var btnCalculate: Button? = null
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        radioMale = findViewById(R.id.radio_male)
        radioFemale = findViewById(R.id.radio_female)
        editHeight = findViewById(R.id.edit_height)
        btnCalculate = findViewById(R.id.button_calculate)
        btnCalculate!!.setOnClickListener { calculateAndDisplayWeight() }
    }

    private fun calculateAndDisplayWeight() {
        val heightText = editHeight!!.text.toString()
        if (heightText.isEmpty()) {
            Toast.makeText(this, "Por favor, digite a altura.", Toast.LENGTH_SHORT).show()
            return
        }
        val height = heightText.toDouble()
        val weight: Double
        weight = if (radioMale!!.isChecked) {
            72.7 * height - 58
        } else {
            62.1 * height - 44.7
        }
        val gender = if (radioMale!!.isChecked) "Masculino" else "Feminino"
        val result = "Peso ideal para " + gender + ": " + String.format("%.2f", weight) + " kg"
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
    }
}
