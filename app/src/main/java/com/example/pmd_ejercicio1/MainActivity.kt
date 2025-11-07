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
    var numero by remember { mutableStateOf("") }
    var ListaEnteros = remember { mutableListOf<Int>() }
    var ListaNegativos = remember { mutableListOf<Int>() }
    var LiostaCero = remember { mutableListOf<Int>() }
    Column(modifier = Modifier.fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Introduce un numero entero positivo, negativo o cero")

        OutlinedTextField(
            value = numero,
            onValueChange = {newNumero ->
                numero = newNumero },
            label = {Text("numero")}
        )
        Button(onClick = {
            InsertarNum(numero, ListaEnteros, ListaNegativos, LiostaCero)
        }) {Text("Inertsr numero")}
    }

}
@Composable
fun InsertarNum(num: String, listaEnteros: MutableList<Int>, listaNegativos: MutableList<Int>, listaCero: MutableList<Int>) {
    if (num.isNotEmpty()) {
        try {
            val numEntero = num.toInt()
            if (numEntero > 0) {
                listaEnteros.add(numEntero)
            } else if (numEntero < 0) {
                listaNegativos.add(numEntero)
            } else {
                listaCero.add(numEntero)
            }
        } catch (e: Exception) {
            println("Caracter no valido")
        }
    }
}
