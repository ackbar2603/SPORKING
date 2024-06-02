package com.example.spork.presentation.profile.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.spork.presentation.component.BoldTextComponent
import com.example.spork.presentation.component.NormalTextComponentJustify
import com.example.spork.presentation.component.Switches
import com.example.spork.presentation.component.TopBar

@Composable
fun notifySecurityScreen(navController: NavController){

    Scaffold (
        topBar = { TopBar(backButton = {navController.navigate(Screen.AccountScreen.route)}, value = stringResource(id = R.string.notifikasi_keamanan_topapp)) }
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
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(120.dp),
                    painter = painterResource(id = R.drawable.icon_lock150),
                    contentDescription = "lock icon")
                Spacer(modifier = Modifier.height(12.dp))
                BoldTextComponent(value = stringResource(id = R.string.chat_and_login))
                
                Spacer(modifier = Modifier.height(8.dp))
                NormalTextComponentJustify(value = stringResource(id = R.string.dapatkan_notifikasi))

                Spacer(modifier = Modifier.height(12.dp))

                Switches(value = stringResource(id = R.string.tampilkan_notifikasi))

            }
        }

    }

}

//@Preview(showBackground = true)
//@Composable
//fun notifySecurityScreenPreview(){
//    notifySecurityScreen()
//}