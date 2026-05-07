package com.example.lab2.screens.addstudent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab2.data.Student

@Composable
fun AddStudentScreen(
    onSaveStudent: (Student) -> Unit,
    onCancel: () -> Unit
) {
    var studentNumber by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Add Student",
            style = MaterialTheme.typography.headlineMedium
        )

        OutlinedTextField(
            value = studentNumber,
            onValueChange = { studentNumber = it },
            label = { Text("Student number") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text("First name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Last name") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val student = Student(
                    studentNumber = studentNumber,
                    firstName = firstName,
                    lastName = lastName
                )

                onSaveStudent(student)
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = studentNumber.isNotBlank() &&
                    firstName.isNotBlank() &&
                    lastName.isNotBlank()
        ) {
            Text("Add Student")
        }

        OutlinedButton(
            onClick = onCancel,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cancel")
        }
    }
}