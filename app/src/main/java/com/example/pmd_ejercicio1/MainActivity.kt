package com.example.pmd_ejercicio1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmd_ejercicio1.ui.theme.PMD_Ejercicio1Theme
import kotlin.collections.mutableListOf

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
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize()
        .padding(40.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Introduce un numero entero positivo, negativo o cero")

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
                    var num = numero.toInt()
                    if (num > 0) {
                        listaEnteros.add(num)
                        Toast.makeText(context,"El numero $num se ha insertado", Toast.LENGTH_LONG).show()
                        numeroEntrada = ""
                    } else if (num < 0) {
                        listaNegativos.add(num)
                        Toast.makeText(context,"El numero $num se ha insertado", Toast.LENGTH_LONG).show()
                        numeroEntrada = ""
                    } else {
                        listaCero.add(num)
                        Toast.makeText(context,"El numero $num se ha insertado", Toast.LENGTH_LONG).show()
                        numeroEntrada = ""
                    }
                } catch (e: Exception) {
                    Toast.makeText(context, "Se permite solo numeros", Toast.LENGTH_LONG).show()
                    numeroEntrada = ""
                    // el error se tiene que imprimir en ventana en un texto en rojo
                    // el error tambien se tiene que ver con Toast

                }
            }else{
                Toast.makeText(context, "Introduce un numero", Toast.LENGTH_LONG).show()
            }

        }) {
            Text("Añadir numero")

        }
       Text("Numeros positivos",
           fontWeight = FontWeight.Bold)
        Text(listaEnteros.toString())
        Text("cantidad de los numeros")
        Text(listaEnteros.size.toString())
        Spacer(modifier = Modifier.height(8.dp))
        Text("Numeros negativos",
            fontWeight = FontWeight.Bold )
        Text(listaNegativos.toString())
        Text("cantidad de los numeros")
        Text(listaNegativos.size.toString())
        Spacer(modifier = Modifier.height(8.dp))
        Text("Ceros",
            fontWeight = FontWeight.Bold)
        Text(listaCero.toString())
        Text("cantidad de los ceros")
        Text(listaCero.size.toString())
        Spacer(modifier = Modifier.height(8.dp))
    }


}



