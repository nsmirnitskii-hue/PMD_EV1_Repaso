package com.example.pmd_ejercicio1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmd_ejercicio1.ui.theme.PMD_Ejercicio1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PMD_Ejercicio1Theme {
                Alicacion()
            }
        }
    }
}
@Composable
fun Alicacion(){
    var numeroEntrada by remember { mutableStateOf("") }
    var listaEnteros = remember { mutableListOf<Int>() }
    var listaNegativos = remember { mutableListOf<Int>() }
    var listaCero = remember { mutableListOf<Int>() }
    var mensajeError by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Introduce un numero entero positivo, negativo o cero")
        Text("aqui pondremos el mensaje de error",
            color = Color.Red)
        OutlinedTextField(
            value = numeroEntrada,
            onValueChange = {newNumero ->
                numeroEntrada = newNumero },
            label = {Text("numero")}
        )
        Button(onClick = {
            // mete el codigo que gestioa la insercion de numeros aqui
            var numero = numeroEntrada
            if (numero.isNotEmpty()) {
                try {
                    val numEntero = numero.toInt()
                    if (numEntero > 0) {
                        listaEnteros.add(numEntero)
                    } else if (numEntero < 0) {
                        listaNegativos.add(numEntero)
                    } else {
                        listaCero.add(numEntero)
                    }
                } catch (e: Exception) {
                    // el error se tiene que imprimir en ventana en un texto en rojo
                    // el error tambien se tiene que ver con Toast
                    println("Caracter no valido")
                }
            }else{
                println("Introduce un numero")
            }
        }) {
            Text("Añadir numero")

        }
    }

}

