package com.example.spork.presentation.community

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.spork.R
import com.example.spork.navigation.Screen
import com.example.spork.presentation.component.BoldTextComponent
import com.example.spork.presentation.component.BottomBar
import com.example.spork.presentation.component.ButtonComponent
import com.example.spork.presentation.component.NormalTextComponentCenterAlign
import com.example.spork.presentation.component.TopBar

@Composable
fun newCommunityScreen(navController: NavController){

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "home"

    Scaffold (
        topBar = { TopBar(backButton = {navController.navigate(Screen.CommunityScreen.route)}, value = stringResource(id = R.string.komunitas)) },
        bottomBar = { BottomBar(navController = navController, currentRoute = currentRoute) }
    ){innerPadding ->
        Surface (
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(24.dp)
                .padding(innerPadding)
        ){
            Column (
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    modifier = Modifier
                        .size(220.dp),
                    painter = painterResource(id = R.drawable.community),
                    contentDescription = null
                )
                BoldTextComponent(value = stringResource(id = R.string.tetap_terhubung))

                Spacer(modifier = Modifier.height(8.dp))
                NormalTextComponentCenterAlign(value = stringResource(id = R.string.bergabunglah_komunitas))

                Spacer(modifier = Modifier.height(14.dp))
                BoldTextComponent(value = stringResource(id = R.string.contoh_komunitas))
                
                Spacer(modifier = Modifier.height(42.dp))
                ButtonComponent(value = stringResource(id = R.string.mulai), onTaskClick = {null})
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun newCommunityScreenPreview(){
    newCommunityScreen(navController = rememberNavController())
}