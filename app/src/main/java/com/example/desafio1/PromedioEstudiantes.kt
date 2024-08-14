package com.example.desafio1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.desafio1.databinding.ActivityPromedioEstudiantesBinding

class PromedioEstudiantes : AppCompatActivity() {

    private lateinit var binding: ActivityPromedioEstudiantesBinding

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPromedioEstudiantesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnExit.setOnClickListener {
            finish()
        }
        binding.calcularButton.setOnClickListener {
            calcular()
        }
    }

    private fun calcular() {
        val nombre = binding.nombre.text.toString()
        val nota1 = binding.nota1.text.toString().toDoubleOrNull()
        val nota2 = binding.nota2.text.toString().toDoubleOrNull()
        val nota3 = binding.nota3.text.toString().toDoubleOrNull()
        val nota4 = binding.nota4.text.toString().toDoubleOrNull()
        val nota5 = binding.nota5.text.toString().toDoubleOrNull()

        if (nota1 != null && nota2 != null && nota3 != null && nota4 != null && nota5 != null) {
            if (listOf(nota1, nota2, nota3, nota4, nota5).all { it in 0.0..10.0 }) {
                val prom = (nota1 * 0.15) + (nota2 * 0.15) + (nota3 * 0.20) + (nota4 * 0.25) + (nota5 * 0.25)
                if (prom >= 6){
                    binding.aprobado.text = "Has aprobado"
                }
                else
                {
                    binding.aprobado.text= "Has reprobado el curso"
                }
                binding.promedioTextView.text = "El promedio de $nombre es: %.2f  ".format(prom)
            } else {
                binding.promedioTextView.text = "Las notas deben estar entre 0 y 10."
            }
        } else {
            binding.promedioTextView.text = "Por favor, ingrese todos los campos."
        }
    }
}
