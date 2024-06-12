package com.example.spork.presentation.allscreen.testing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.spork.R
import com.example.spork.presentation.component.BoldTextComponent

@Composable
fun agreementScreen(){

    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(24.dp)
    ){
        Column (
            modifier = Modifier.fillMaxSize()
        ){
            BoldTextComponent(value = stringResource(id = R.string.term_and_conditions))
        }
    }
}

@Preview
@Composable
fun agreementScreenPreview(){
    agreementScreen()
}