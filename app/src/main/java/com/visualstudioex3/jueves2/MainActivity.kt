package com.visualstudioex3.jueves2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaContadorColores()
        }
    }
}

@Composable
fun PantallaContadorColores() {
    // 1. Estado para el texto de la frase
    var textoPantalla by remember { mutableStateOf("¡Hola, programador!") }

    // 2. Estado para el contador de clics (empieza en 0)
    var contadorClicks by remember { mutableIntStateOf(0) }

    // 3. Lógica condicional para elegir el color de fondo:
    // Si el residuo de dividir entre 2 es 0, el número es par.
    val colorFondo = if (contadorClicks % 2 == 0) {
        Color(0xFFE8F5E9) // Verde claro
    } else {
        Color(0xFFE3F2FD) // Azul claro
    }

    // 4. Contenedor principal (Column) al que le aplicamos el color de fondo dinámico
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorFondo) // Aquí aplicamos el color guardado en la variable
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Mostramos la frase motivacional
        Text(
            text = textoPantalla,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 5. Mostramos el contador de clics en tiempo real
        Text(
            text = "Clicks: $contadorClicks",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        // 6. Botón de acción
        Button(onClick = {
            // Acción 1: Cambiamos la frase
            textoPantalla = "¡Cada click te acerca más a tu meta!"

            // Acción 2: Sumamos 1 al contador actual
            contadorClicks++
        }) {
            Text(text = "Pulsar y Cambiar")
        }
    }
}
