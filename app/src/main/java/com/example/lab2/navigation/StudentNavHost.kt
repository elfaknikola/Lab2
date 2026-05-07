package com.example.lab2.navigation

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab2.data.Student
import com.example.lab2.screens.addstudent.AddStudentScreen
import com.example.lab2.screens.studentlist.StudentListScreen

@Composable
fun StudentNavHost() {
    val navController = rememberNavController()
    val context = LocalContext.current
    var students by remember {
        mutableStateOf(
            listOf(
                Student("10458", "Petar", "Petrovic"),
                Student("10568", "Jelena", "Jovanovic")
            )
        )
    }

    var selectedStudent by remember {
        mutableStateOf<Student?>(null)
    }

    NavHost(
        navController = navController,
        startDestination = Routes.STUDENT_LIST
    ) {
        composable(Routes.STUDENT_LIST) {
            StudentListScreen(
                students = students,
                onAddClick = {
                    navController.navigate(Routes.ADD_STUDENT)
                },
                onStudentClick = { student ->
                    selectedStudent = student
                    Toast.makeText(context, selectedStudent.toString(), Toast.LENGTH_LONG).show()
                    //TODO:Navigate to student details
                    //navController.navigate(Routes.STUDENT_DETAILS)
                }
            )
        }

        composable(Routes.ADD_STUDENT) {
            AddStudentScreen(
                onSaveStudent = { student ->
                    students = students + student
                    navController.popBackStack()
                },
                onCancel = {
                    navController.popBackStack()
                }
            )
        }
    }
}