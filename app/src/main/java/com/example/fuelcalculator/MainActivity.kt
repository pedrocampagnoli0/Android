package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main)

        val editTextGasMileage = findViewById<EditText>(R.id.editTextGasMileage)
        val editTextEthanolMileage = findViewById<EditText>(R.id.editTextEthanolMileage)
        val editTextGasPrice = findViewById<EditText>(R.id.editTextGasPrice)
        val editTextEthanolPrice = findViewById<EditText>(R.id.editTextEthanolPrice)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val gasMileage = editTextGasMileage.text.toString().toFloatOrNull() ?: 0f
            val ethanolMileage = editTextEthanolMileage.text.toString().toFloatOrNull() ?: 0f
            val gasPrice = editTextGasPrice.text.toString().toFloatOrNull() ?: 0f
            val ethanolPrice = editTextEthanolPrice.text.toString().toFloatOrNull() ?: 0f

            Intent(this, Calculate::class.java).apply {
                putExtra("gasMileage", gasMileage)
                putExtra("ethanolMileage", ethanolMileage)
                putExtra("gasPrice", gasPrice)
                putExtra("ethanolPrice", ethanolPrice)
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