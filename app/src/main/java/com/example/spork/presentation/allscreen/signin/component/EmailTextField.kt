package com.example.spork.presentation.allscreen.signin.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.spork.R
import com.example.spork.ui.theme.mainOrange
import com.example.spork.ui.theme.primary


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun EmailTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    contentDescription: String,
    modifier: Modifier = Modifier,
){
//    Text(
//        text = value,
//        modifier = Modifier
//            .fillMaxWidth()
//            .heightIn(),
//        style = TextStyle(
//            fontSize = 18.sp,
//            fontWeight = FontWeight.Medium,
//            fontStyle = FontStyle.Normal
//        ),
//        color = colorResource(id = R.color.orange_7900),
//        textAlign = TextAlign.Start
//    )

    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = mainOrange,
            focusedLabelColor = mainOrange,
            cursorColor = primary,
        ),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.mail),
                contentDescription = "Email icon"
            )
        },
        label = { Text(text = label) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii),
        value = value,
        onValueChange = onValueChange,

        )
}