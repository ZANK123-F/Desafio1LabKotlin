package com.example.desafio1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.desafio1.databinding.ActivityCalculadoraBinding



class Calculadora : AppCompatActivity() {
    private lateinit var binding: ActivityCalculadoraBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalculadoraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSumar.setOnClickListener { calculate(Operation.ADD) }
        binding.buttonRestar.setOnClickListener { calculate(Operation.SUBTRACT) }
        binding.buttonMultiplicar.setOnClickListener { calculate(Operation.MULTIPLY) }
        binding.buttonDividir.setOnClickListener { calculate(Operation.DIVIDE) }
        binding.btnExit.setOnClickListener { finish() }


    }

    private fun calculate(operation: Operation) {
        val input1Text = binding.input1.text.toString()
        val input2Text = binding.input2.text.toString()

        if (input1Text.isEmpty() || input2Text.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa ambos números", Toast.LENGTH_SHORT).show()
            return
        }

        val num1 = input1Text.toDouble()
        val num2 = input2Text.toDouble()
        var result = 0.0

        when (operation) {
            Operation.ADD -> result = num1 + num2
            Operation.SUBTRACT -> result = num1 - num2
            Operation.MULTIPLY -> result = num1 * num2
            Operation.DIVIDE -> {

                if (num2 == 0.0) {
                    Toast.makeText(this, "No se puede dividir por cero", Toast.LENGTH_SHORT).show()
                    return
                }
                result = num1 / num2
            }
        }
        binding.textViewResult.text = "Resultado: $result"
    }

    enum class Operation {
        ADD, SUBTRACT, MULTIPLY,DIVIDE
        }
}