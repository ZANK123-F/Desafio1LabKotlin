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


    }
}
