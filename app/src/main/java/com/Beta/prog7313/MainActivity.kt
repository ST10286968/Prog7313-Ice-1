
package com.Beta.prog7313

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.text.toDouble
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        var num1 = findViewById<EditText>(R.id.editTextNumberDecimal).text.toString().toDouble()
//        var num2 = findViewById<EditText>(R.id.editTextNumberDecimal2).text.toString().toDouble()
//        var result  = findViewById<TextView>(R.id.textView3)
//        result = num1 + num2
//        findViewById<TextView>(R.id.textView3).text = result.toString()
//
//        button = findViewById<Button>(R.id.button)
//        button = setOnClickListener { result}
        val num1EditText = findViewById<EditText>(R.id.editTextNumberDecimal)
        val num2EditText = findViewById<EditText>(R.id.editTextNumberDecimal2)
        val resultTextView = findViewById<TextView>(R.id.textView3)
        val calculateButton = findViewById<Button>(R.id.button)
        val backButton = findViewById<Button>(R.id.button2)


        backButton.setOnClickListener {
            val intent = Intent(this, MainActivityNavePage::class.java)
            startActivity(intent)
        }

        // Set the click listener for the button
        calculateButton.setOnClickListener {
            // Get the text from the EditText fields
            val num1String = num1EditText.text.toString()
            val num2String = num2EditText.text.toString()

            // Perform the calculation and update the TextView
            try {
                // Try to convert the strings to Doubles
                val num1 = num1String.toDouble()
                val num2 = num2String.toDouble()

                // Calculate the sum
                val result = num1 + num2

                // Update the TextView with the result
                resultTextView.text = result.toString()
            } catch (e: NumberFormatException) {
                // Handle the case where the user entered non-numeric text
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
                resultTextView.text = "" // Clear the result if there was an error
            }

        }
    }
}
