package com.example.spork.presentation.allscreen.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.spork.R
import com.example.spork.presentation.component.BoldTextOrangeComponent
import com.example.spork.presentation.component.ButtonComponent
import com.example.spork.presentation.component.CheckBoxComponent
import com.example.spork.presentation.component.MyOutlinedTextField
import com.example.spork.presentation.component.NormalTextComponent
import com.example.spork.presentation.component.PasswordTextField
import com.example.spork.presentation.component.TopBar
import com.example.spork.navigation.Screen
import com.example.spork.presentation.component.ClickableTextSudahPunyaAkunComponent

@Composable
fun signUpScreen(navController: NavController){
    Scaffold (
        topBar = { TopBar(backButton = {null}, value = stringResource(id = R.string.none))}
    ){innerPadding ->
        Surface (
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(24.dp)
                .padding(innerPadding)
        ){
            Column (
                modifier = Modifier.fillMaxSize()
            ){
                BoldTextOrangeComponent(value = stringResource(id = R.string.daftar_akun))

                Spacer(modifier = Modifier.height(42.dp))
                MyOutlinedTextField(labelValue = stringResource(id = R.string.nama_depan), value = stringResource(
                    id = R.string.nama_depan), painterResource = painterResource(id = R.drawable.person_x64)
                )
                Spacer(modifier = Modifier.height(16.dp))
                MyOutlinedTextField(labelValue = stringResource(id = R.string.nama_belakang), value = stringResource(
                    id = R.string.nama_belakang), painterResource = painterResource(id = R.drawable.person_x64)
                )
                Spacer(modifier = Modifier.height(16.dp))
                PasswordTextField(labelValue = stringResource(id = R.string.password), value = stringResource(
                    id = R.string.password), painterResource = painterResource(id = R.drawable.lock)
                )
                Spacer(modifier = Modifier.height(16.dp))
                PasswordTextField(labelValue = stringResource(id = R.string.repeat_password), value = stringResource(
                    id = R.string.repeat_password), painterResource = painterResource(id = R.drawable.lock)
                )
                CheckBoxComponent(value = stringResource(id = R.string.term_of_use),
                    onTextSelected = {navController.navigate(Screen.Agreement.route)}
                )

                Spacer(modifier = Modifier.height(24.dp))
                ClickableTextSudahPunyaAkunComponent(onTextSelected = {navController.navigate(Screen.SignIn.route)})
                Spacer(modifier = Modifier.height(24.dp))

                ButtonComponent(value = stringResource(id = R.string.daftar_akun), onTaskClick = { null })
            }
        }

    }
}

@Preview
@Composable
fun signUpScreenPreview(){
    signUpScreen(navController = rememberNavController())
}

//navController.navigate(Screen.SignIn.route)
//navController.navigate(Screen.Agreement.route)


