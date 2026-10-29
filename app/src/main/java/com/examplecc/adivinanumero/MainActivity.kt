package com.examplecc.adivinanumero

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

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

        val numeroAleatorio = Random.nextInt(1,101)
        val boton = findViewById<Button>(R.id.boton)
        val mensaje = findViewById<TextView>(R.id.mensaje)
        var contador = 0

        val numeroIntroducido = findViewById<EditText>(R.id.Texto)
        boton.setOnClickListener {
            val numero = numeroIntroducido.text.toString().toIntOrNull()

            if (numero == null || numero !in 1..100){
                numeroIntroducido.error="introduce un numero entre 1 y 100"

            }else {
                contador++
                val mensaje =when {
                    numero < numeroAleatorio -> mensaje.text ="El numero es mayor"
                    numero > numeroAleatorio -> mensaje.text = "El numero es menor"
                    else -> mensaje.text = "Perfecto has tardado " + contador + " Intentos"

                }
                numeroIntroducido.text.clear()
        }



        }
    }
}