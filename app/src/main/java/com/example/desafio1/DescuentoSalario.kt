package com.example.desafio1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.desafio1.databinding.ActivityDescuentoSalarioBinding

class DescuentoSalario : AppCompatActivity() {
    private lateinit var binding: ActivityDescuentoSalarioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescuentoSalarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnExit.setOnClickListener {
            finish()
        }
        binding.Calcular.setOnClickListener {
            CalcularDescuento()
        }
    }

    @SuppressLint("SetTextI18n", "DefaultLocale")
    private fun CalcularDescuento() {
        val nombre = binding.Nombre.text.toString().trim()
        val salariotext = binding.salariobasw.text.toString().trim()
        val salariobase = salariotext.toDoubleOrNull()

        if (nombre.isEmpty() || salariotext.isEmpty()) {
            binding.Resultado.text = "por favor complete ambos campos."
            return
        }

        if (salariobase == null  ) {
            binding.Resultado.text = "por favor, ingrese un salario válido."
            return
        }


        val renta = calcularRenta(salariobase)
        val afp = salariobase * 0.0725
        var isss = salariobase * 0.03
//        if (isss > 30){
//            isss = 30.00
//
//        }
        val salarioNeto = salariobase - renta - afp - isss



        binding.Resultado.text =
                "Renta: ${String.format("%.2f", renta)} \n\n" +
                "AFP: ${String.format("%.2f", afp)} \n" + "\n" +
                "ISS: ${String.format("%.2f", isss)} \n" + "\n" +
                "Salario neto: ${String.format("%.2f", salarioNeto)} \n"

    }

    private fun calcularRenta(salarioBase: Double): Double {
        return when {
            salarioBase <= 472.00 -> 0.0
            salarioBase <= 895.24 -> (salarioBase - 472.00) * 0.10 + 17.67
            salarioBase <= 2038.10 -> (salarioBase - 895.24) * 0.20 + 60.0

            else -> (salarioBase - 2038.10) * 0.30 + 288.57

        }
    }
}



