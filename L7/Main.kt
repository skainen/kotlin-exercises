package com.example.l7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Counter(
    val id: Int,
    val name: String,
    var value: Int = 0
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MultiCounterApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MultiCounterApp() {
    var counters by remember { mutableStateOf(List(5) { Counter(it, "Counter_${it + 1}") }) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Multi counter") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                val newId = counters.size
                counters = counters + Counter(newId, "Counter_${newId + 1}")
            }) {
                Icon(Icons.Default.Add, contentDescription = "Add Counter")
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(counters, key = { it.id }) { counter ->
                CounterItem(
                    counter = counter,
                    onIncrement = {
                        counters = counters.map {
                            if (it.id == counter.id) it.copy(value = it.value + 1)
                            else it
                        }
                    },
                    onDecrement = {
                        counters = counters.map {
                            if (it.id == counter.id) it.copy(value = it.value - 1)
                            else it
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun CounterItem(
    counter: Counter,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = counter.name,
                style = MaterialTheme.typography.titleMedium
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = onDecrement) {
                    Text("-", fontSize = 20.sp)
                }

                Text(
                    text = counter.value.toString(),
                    style = MaterialTheme.typography.headlineMedium
                )

                Button(onClick = onIncrement) {
                    Text("+", fontSize = 20.sp)
                }
            }
        }
    }
}
