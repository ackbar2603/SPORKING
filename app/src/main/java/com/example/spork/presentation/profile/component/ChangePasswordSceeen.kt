package com.example.spork.presentation.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.spork.presentation.component.ButtonComponent
import com.example.spork.presentation.component.CheckBoxComponent
import com.example.spork.presentation.component.CheckBoxComponentWithTextOnly
import com.example.spork.presentation.component.NormalTextComponent
import com.example.spork.presentation.component.NormalTextComponentJustify
import com.example.spork.presentation.component.PasswordTextField
import com.example.spork.presentation.component.TopBar

@Composable
fun changePasswordScreen(navController: NavController){

    Scaffold (
        topBar = { TopBar(backButton = {navController.navigate(Screen.AccountScreen.route)}, value = stringResource(id = R.string.ubah_password)) }
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
                NormalTextComponentJustify(value = stringResource(id = R.string.password_anda_paling_tidak))

                Spacer(modifier = Modifier.height(8.dp))
                PasswordTextField(labelValue = stringResource(id = R.string.passowrd_saatini), value = stringResource(
                    id = R.string.none), painterResource = painterResource(id = R.drawable.icon_lock))
                PasswordTextField(labelValue = stringResource(id = R.string.password_baru), value = stringResource(
                    id = R.string.none), painterResource = painterResource(id = R.drawable.icon_lock))
                PasswordTextField(labelValue = stringResource(id = R.string.repassword), value = stringResource(
                    id = R.string.none), painterResource = painterResource(id = R.drawable.icon_lock))
                Spacer(modifier = Modifier.height(12.dp))
                CheckBoxComponentWithTextOnly(value = stringResource(id = R.string.logout_dari_perangkatlain))
                Spacer(modifier = Modifier.height(24.dp))
                ButtonComponent(value = stringResource(id = R.string.ubah_password), onTaskClick = {null})
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun changePasswordScreenPreview(){
    changePasswordScreen(navController = rememberNavController())
}