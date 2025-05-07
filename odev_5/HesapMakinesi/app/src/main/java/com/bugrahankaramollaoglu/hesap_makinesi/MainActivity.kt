package com.bugrahankaramollaoglu.hesap_makinesi

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.bugrahankaramollaoglu.hesap_makinesi.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var resultExpression: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup buttons for numbers
        setupButton(binding.zeroButton, "0")
        setupButton(binding.oneButton, "1")
        setupButton(binding.twoButton, "2")
        setupButton(binding.threeButton, "3")
        setupButton(binding.fourButton, "4")
        setupButton(binding.fiveButton, "5")
        setupButton(binding.sixButton, "6")
        setupButton(binding.sevenButton, "7")
        setupButton(binding.eightButton, "8")
        setupButton(binding.nineButton, "9")

        // Setup buttons for operations
        setupButton(binding.plusButton, "+")
        setupButton(binding.minusButton, "-")

        // Clear button
        binding.clearButton.setOnClickListener {
            resultExpression = ""
            binding.resultText.text = ""
        }

        // Result button
        binding.resultButton.setOnClickListener {
            try {
                // Evaluate the expression using exp4j
                val expression = ExpressionBuilder(resultExpression).build()
                val result = expression.evaluate()
                binding.resultText.text = result.toString()
                resultExpression = result.toString() // Let user continue calculation
            } catch (e: Exception) {
                binding.resultText.text = "Error"
                resultExpression = ""
            }
        }
    }

    // Function to handle number and operator buttons
    private fun setupButton(button: Button, value: String) {
        button.setOnClickListener {
            if (resultExpression.isNotEmpty() && resultExpression[0] != '0') {
                resultExpression += value
                binding.resultText.text = resultExpression
            } else if (resultExpression.isEmpty() && value != "0") {
                resultExpression += value
                binding.resultText.text = resultExpression
            }
        }
    }
}
