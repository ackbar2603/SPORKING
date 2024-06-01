package com.example.spork.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.spork.R
import com.example.spork.presentation.component.BoldTextComponent
import com.example.spork.presentation.component.BottomBar
import com.example.spork.presentation.component.TopBar

@Composable
fun homeScreen(
    navController: NavController,

    ){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "home"

    Scaffold (
        topBar = { TopBar(backButton = {null}, value = stringResource(id = R.string.none))},
        bottomBar = { BottomBar(navController = navController, currentRoute = currentRoute)}
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
                Spacer(modifier = Modifier.height(120.dp))
                BoldTextComponent(value = stringResource(id = R.string.home))
            }
        }
    }

}



//@Preview(showBackground = true)
//@Composable
//fun homeScreenPreview(){
//    homeScreen()
//}