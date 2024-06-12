package com.example.spork.presentation.allscreen.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.spork.R
import com.example.spork.presentation.component.ButtonComponent
import com.example.spork.navigation.Screen

@Composable
fun welcomeScreen(navController: NavController){

    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(24.dp)
    ){
        Column (
            modifier = Modifier.fillMaxSize()
        ){
            Spacer(modifier = Modifier.height(250.dp))
            Image(painter = painterResource(id = R.drawable.sprorkinglogoandtext),
                contentDescription = "Sporking",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(300.dp))
            ButtonComponent(value = stringResource(id = R.string.lanjut),
                onTaskClick = { navController.navigate(Screen.Login.route)}
            )
        }
    }

}

//@Preview
//@Composable
//fun welcomeScreenPreview(){
//    welcomeScreen()
//}