package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fuelcalculator.R.id.textViewEthanolEfficiency
import com.example.fuelcalculator.R.id.textViewGasolineEfficiency

class Calculate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_calculate)

        val gasMileage = intent.getFloatExtra("gasMileage", 0f)
        val ethanolMileage = intent.getFloatExtra("ethanolMileage", 0f)
        val gasPrice = intent.getFloatExtra("gasPrice",0f)
        val ethanolPrice = intent.getFloatExtra("ethanolPrice", 0f)

        val money = 100

        val calculateEthanolEfficiency = (money / ethanolPrice) * ethanolMileage
        val efficiencyEthanol = findViewById<TextView>(textViewEthanolEfficiency)
        efficiencyEthanol.text = "%.2fKm".format(calculateEthanolEfficiency)

        val calculateGasolineEfficiency = (money / gasPrice) * gasMileage
        val efficiencyGasoline = findViewById<TextView>(textViewGasolineEfficiency)
        efficiencyGasoline.text = "%.2fKm".format(calculateGasolineEfficiency)


        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            Intent(this, MainActivity::class.java).apply {
                startActivity(this) // Start the Calculate activity
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}