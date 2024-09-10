package com.dqitech.roomdatabase

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.time.Duration.Companion.days
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CheckInScreen(checkInViewModel: CheckInViewModel = hiltViewModel()) {
    val checkIns = checkInViewModel.checkIns.collectAsState(initial = emptyList())

    val name = remember { mutableStateOf("") }
    val days = remember { mutableStateOf<Long>(0) }

    Column {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(value = name.value, onValueChange = { name.value = it },
                label = {
                    Text(
                        text = "Name"
                    )
                })
            OutlinedTextField(value = days.value.toString(),
                onValueChange = { days.value = it.toLong() },
                label = {
                    Text(
                        text = "Stay"
                    )
                })

            Button(onClick = {
                checkInViewModel.insertCheckIn(
                    CheckIn(name = name.value, days = days.value)
                )
                name.value = ""
                days.value = 0
            }) {
                Text(text = "New Check-In")
            }
        }
        LazyColumn(modifier = Modifier.padding(10.dp)) {
            items(checkIns.value) { checkIn ->
                Card(
                    modifier = Modifier.padding(10.dp).fillMaxWidth(),
                   // elevation = 10.dp,
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Text(text = "Name: " + checkIn.name)
                        Text(text = "Days: " + checkIn.days.toString())
                    }

                }
            }
        }
    }
}