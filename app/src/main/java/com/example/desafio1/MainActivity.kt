package com.example.desafio1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.desafio1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculadora.setOnClickListener {
            val intent = Intent(this, Calculadora::class.java)
            startActivity(intent)
        }
        binding.btnPromedioEstudiantes.setOnClickListener {
            val intent = Intent(this, PromedioEstudiantes::class.java)
            startActivity(intent)
        }
        binding.btnDescuentoSalario.setOnClickListener {
            val intent = Intent(this, DescuentoSalario::class.java)
            startActivity(intent)
            }

        }
}