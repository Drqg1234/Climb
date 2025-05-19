package com.example.climb

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController



@Composable
fun LoginScreen(navController: NavHostController) {
    var username by remember { mutableStateOf("")}
    var password by remember { mutableStateOf("")}


    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Login Screen")

        UsernameTextField(username = username, onUsernameChange = { username = it })
        PasswordTextField(password = password, onPasswordChange = { password = it })
//        Modifier.padding(20.dp)
        Button(onClick = {
            navController.navigate(Routes.homeScreen + "/$username")
        }) {
            Text(text = "Login");
        }
    }
}

@Composable
fun UsernameTextField(username: String, onUsernameChange: (String) -> Unit){

    OutlinedTextField(
        value = username,
        onValueChange = onUsernameChange,
        label = { Text("Username")},
        placeholder = { Text("ex: John Doe")},
        singleLine = true,
        //modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun PasswordTextField(password: String, onPasswordChange: (String) -> Unit){

    val isValid = password.contains("[!\"#$%&'()*+,-./:;\\\\<=>?@\\[\\]^_`{|}~]".toRegex()) &&
            password.length >= 8 && password.contains("[A-Za-z]".toRegex()) &&
            password.contains("[0-9]".toRegex())

    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        label = { Text("Password")},
        visualTransformation = PasswordVisualTransformation(),
        isError = password.isNotEmpty() && !isValid,
        placeholder = { Text("ex: pass123*")},
        singleLine = true,

        //modifier = Modifier.fillMaxWidth()
    )
//    if (!isValid){
//        Column(
//            Modifier.fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Text(
//                text = "Password must be: length 8, contain letters, numbers, and a special character"
//            )
//        }
//    }
}


