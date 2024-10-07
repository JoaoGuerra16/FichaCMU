package com.example.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.activities.ui.theme.ActivitiesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ActivitiesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainActivityContent(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart") // Log do onStart
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume") // Log do onResume
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause") // Log do onPause
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop") // Log do onStop
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy") // Log do onDestroy
    }
}

@Composable
fun MainActivityContent(modifier: Modifier = Modifier) {
    // Estado para armazenar o texto inserido
    var text by remember { mutableStateOf("") }

    // Obtenção do contexto para uso no Toast e Intent
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Escreva um texto") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                // Mostra um Toast com o texto digitado
                Toast.makeText(
                    context,
                    text.ifEmpty { "Nenhum texto inserido" },
                    Toast.LENGTH_SHORT
                ).show()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Apresentar Toast")
        }

        Button(
            onClick = {
                // Abre a SecondActivity e envia o texto como um extra no Intent
                val intent = Intent(context, SecondActivity::class.java)
                intent.putExtra("text_input", text) // Passa o texto como extra
                context.startActivity(intent)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Abrir Nova Activity")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    ActivitiesTheme {
        MainActivityContent()
    }
}
