package com.example.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.activities.ui.theme.ActivitiesTheme

class SecondActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SecondActivity", "onCreate") // Log do onCreate
        val text = intent.getStringExtra("text_input") ?: "Nenhum texto recebido"
        setContent {
            ActivitiesTheme {
                SecondActivityContent(text, onBackClick = { finish() })
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("SecondActivity", "onStart") // Log do onStart
    }

    override fun onResume() {
        super.onResume()
        Log.d("SecondActivity", "onResume") // Log do onResume
    }

    override fun onPause() {
        super.onPause()
        Log.d("SecondActivity", "onPause") // Log do onPause
    }

    override fun onStop() {
        super.onStop()
        Log.d("SecondActivity", "onStop") // Log do onStop
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SecondActivity", "onDestroy") // Log do onDestroy
    }
}

@Composable
fun SecondActivityContent(text: String, onBackClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { onBackClick() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar")
        }
    }
}