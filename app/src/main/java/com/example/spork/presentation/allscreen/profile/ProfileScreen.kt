package com.example.spork.presentation.allscreen.profile

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
import com.example.spork.navigation.Screen
import com.example.spork.presentation.component.BoldTextComponent
import com.example.spork.presentation.component.ImagePickerGallery
import com.example.spork.presentation.component.TopBar
import com.example.spork.presentation.component.transparentButtonComponent

@Composable
fun profileScreen(navController: NavController){
Scaffold (
    topBar = { TopBar(backButton = {null}, value = stringResource(id = R.string.none)) }
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
            ImagePickerGallery()
            Spacer(modifier = Modifier.height(12.dp))

            transparentButtonComponent(value = stringResource(id = R.string.akun), image = painterResource(
                id = R.drawable.icon_lock), onTaskClick = {navController.navigate(Screen.AccountScreen.route)}
            )
            Spacer(modifier = Modifier.height(8.dp))
            transparentButtonComponent(value = stringResource(id = R.string.beri_rating), image = painterResource(
                id = R.drawable.icon_star), onTaskClick = {null})
        }

    }

}

}

@Preview(showBackground = true)
@Composable
fun profileScreenPreview(){
    profileScreen(navController = rememberNavController())
}