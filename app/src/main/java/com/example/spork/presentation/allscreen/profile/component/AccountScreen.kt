package com.example.spork.presentation.allscreen.profile.component

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
import com.example.spork.R
import com.example.spork.navigation.Screen
import com.example.spork.presentation.component.TopBar
import com.example.spork.presentation.component.transparentButtonComponent

@Composable
fun accountScreenProfile(navController: NavController){

    Scaffold (
        topBar = { TopBar(backButton = {navController.navigate(Screen.ProfileScreen.route)}, value = stringResource(id = R.string.akun)) }
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
                transparentButtonComponent(value = stringResource(id = R.string.notifikasi_keamanan),
                    image = painterResource(id = R.drawable.icon_lock64), onTaskClick = {navController.navigate(Screen.SecurityNotify.route)})
                Spacer(modifier = Modifier.height(12.dp))

                transparentButtonComponent(value = stringResource(id = R.string.ubah_password), image = painterResource(
                    id = R.drawable.icon_key64), onTaskClick = {navController.navigate(Screen.ChangePasswordScreen.route)})
                Spacer(modifier = Modifier.height(12.dp))

                transparentButtonComponent(value = stringResource(id = R.string.alamat_email),
                    image = painterResource(id = R.drawable.icon_mail64), onTaskClick = {null})
                Spacer(modifier = Modifier.height(12.dp))

                transparentButtonComponent(value = stringResource(id = R.string.hapus_akun), image = painterResource(
                    id = R.drawable.icon_trash64), onTaskClick = {null})
            }
        }
    }

}

//@Preview(showBackground = true)
//@Composable
//fun accountScreenProfilePreview(){
//    accountScreenProfile()
//}