package com.example.spork.presentation.component

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.spork.R
import com.example.spork.navigation.Screen
import com.example.spork.ui.theme.clickableBlueish
import com.example.spork.ui.theme.mainOrange
import com.example.spork.ui.theme.primary
import com.example.spork.ui.theme.secondButton



//Top Bar and Bottom Bar Navigation
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopBar(value: String, backButton: () -> Unit){
    TopAppBar(title = {
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            IconButton(onClick = backButton) {
                Image(painter = painterResource(id = R.drawable.arrowleft),
                    contentDescription = "back arrow",
                    modifier = Modifier.padding(end = 12.dp)
                )
            }
            Text(text = value,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                ),
                color = colorResource(id = R.color.orange_7900)
            )

        }
    })
}


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun BottomBar(navController: NavController, currentRoute: String){
    val orangeColor = Color(0xFFFD7900)
    val textColor = Color(0xFF8F8C95)

    BottomAppBar(
        containerColor = Color.White,
        contentColor = orangeColor, // Warna latar belakang bottom app bar
        contentPadding = PaddingValues(16.dp) // Padding konten dalam bottom app bar
    ){
        IconButton(
            onClick = { navController.navigate(Screen.HomeScreen.route) },
            modifier = Modifier.weight(1f)
        ) {
            Column (
                modifier = Modifier.fillMaxWidth(), // Atau sesuaikan dengan kebutuhan
                horizontalAlignment = Alignment.CenterHorizontally, // Menjadikan semua anak di dalam Column terpusat secara horizontal
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.icon_home),
                    contentDescription = "Home",
                    modifier = Modifier.size(20.dp),
                    colorFilter = ColorFilter.tint(if (currentRoute == "beranda") orangeColor else textColor)
                )
                Text(
                    text = "Beranda",
                    fontSize = 10.sp,
                    color = if (currentRoute == "beranda") orangeColor else textColor
                )
            }
        }
        IconButton(
            onClick = { navController.navigate("lapangan") },
            modifier = Modifier.weight(1f)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(), // Atau sesuaikan dengan kebutuhan
                horizontalAlignment = Alignment.CenterHorizontally, // Menjadikan semua anak di dalam Column terpusat secara horizontal
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_field),
                    contentDescription = "Field",
                    modifier = Modifier.size(20.dp),
                    colorFilter = ColorFilter.tint(if (currentRoute == "category") orangeColor else textColor)
                )
                Text(
                    text = "Lapangan",
                    fontSize = 10.sp,
                    color = if (currentRoute == "category") orangeColor else textColor
                )
            }
        }
        IconButton(
            onClick = { navController.navigate(Screen.NewsScreen.route) },
            modifier = Modifier.weight(1f)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(), // Atau sesuaikan dengan kebutuhan
                horizontalAlignment = Alignment.CenterHorizontally, // Menjadikan semua anak di dalam Column terpusat secara horizontal
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_soccer_ball),
                    contentDescription = "News",
                    modifier = Modifier.size(20.dp),
                    colorFilter = ColorFilter.tint(if (currentRoute == "news") orangeColor else textColor)
                )
                Text(
                    text = "News",
                    fontSize = 10.sp,
                    color = if (currentRoute == "news") orangeColor else textColor
                )
            }
        }
        IconButton(
            onClick = { navController.navigate("booking") },
            modifier = Modifier.weight(1f)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(), // Atau sesuaikan dengan kebutuhan
                horizontalAlignment = Alignment.CenterHorizontally, // Menjadikan semua anak di dalam Column terpusat secara horizontal
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_calender),
                    contentDescription = "Pemesanan",
                    modifier = Modifier.size(20.dp),
                    colorFilter = ColorFilter.tint(if (currentRoute == "booking") orangeColor else textColor)
                )
                Text(
                    text = "Pemesanan",
                    fontSize = 10.sp,
                    color = if (currentRoute == "booking") orangeColor else textColor
                )
            }
        }
        IconButton(
            onClick = { navController.navigate("community") },
            modifier = Modifier.weight(1f)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(), // Atau sesuaikan dengan kebutuhan
                horizontalAlignment = Alignment.CenterHorizontally, // Menjadikan semua anak di dalam Column terpusat secara horizontal
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_person),
                    contentDescription = "community",
                    modifier = Modifier.size(20.dp),
                    colorFilter = ColorFilter.tint(if (currentRoute == "komunitas") orangeColor else textColor)
                )
                Text(
                    text = "community",
                    fontSize = 10.sp,
                    color = if (currentRoute == "community") orangeColor else textColor
                )
            }
        }
    }
}

// Normal Text Component
@Composable
fun NormalTextComponent(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.blackfont),
        textAlign = TextAlign.Center
    )
}

@Composable
fun NormalTextComponentJustify(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.blackfont),
        textAlign = TextAlign.Justify
    )
}

// Bold Orange Text Component
@Composable
fun BoldTextOrangeComponent(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 30.dp),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.orange_7900),
        textAlign = TextAlign.Center
    )
}

// Bold Text Component
@Composable
fun BoldTextComponent(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 30.dp),
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.blackfont),
        textAlign = TextAlign.Center
    )
}

// Outlined Text Field Normal
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MyOutlinedTextField(labelValue: String, value: String, painterResource: Painter){

    var textValue by remember {
        mutableStateOf("")
    }

    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.orange_7900),
        textAlign = TextAlign.Start
    )

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = mainOrange,
            focusedLabelColor = mainOrange,
            cursorColor = primary,
        ),
        keyboardOptions = KeyboardOptions.Default,
        value = textValue,
        onValueChange = {
            textValue = it
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "email logo")
        },
    )
}

// Outlined Text Field Password
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun PasswordTextField(labelValue: String, value: String, painterResource: Painter){

    var password by remember {
        mutableStateOf("")
    }

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.orange_7900),
        textAlign = TextAlign.Start
    )

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(10.dp),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = mainOrange,
            focusedLabelColor = mainOrange,
            cursorColor = primary,
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value = password,
        onValueChange = {
            password = it
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "lock logo")
        },
        trailingIcon = {
            val iconImage = if (passwordVisible) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }
            var description = if (passwordVisible){
                stringResource(id = R.string.hide_password)
            } else {
                stringResource(id = R.string.show_password)
            }

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
    )

}

@Composable
fun ButtonComponent(value: String, onTaskClick: () -> Unit){
    Button(
        onClick = onTaskClick,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(52.dp),
        shape = RoundedCornerShape(7.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(mainOrange)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    color = mainOrange
                ),
            contentAlignment = Alignment.Center
        ){
            Text(text = value,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

// Google Button Component
@Composable
fun GoogleButtonComponent(value: String, image: Painter, onTaskClick: () -> Unit){
    Button(
        onClick = onTaskClick,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(52.dp),
        shape = RoundedCornerShape(7.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(secondButton)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    color = secondButton
                ),
            contentAlignment = Alignment.Center,
        ){
            Image(modifier = Modifier.padding(end = 280.dp),painter = image, contentDescription = "")
            Text(text = value,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = mainOrange
            )
        }
    }

}

//
@Composable
fun transparentButtonComponent(value: String, image: Painter, onTaskClick: () -> Unit){
    OutlinedButton(
        onClick = onTaskClick,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(52.dp),
        shape = RoundedCornerShape(7.dp),
        contentPadding = PaddingValues(),
        border = BorderStroke(0.dp, Color.Transparent),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp),
            contentAlignment = Alignment.Center,
        ){
            Image(modifier = Modifier.padding(end = 320.dp),painter = image, contentDescription = "")
            Text(text = value,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn()
                    .padding(start = 50.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    fontStyle = FontStyle.Normal
                ),
                color = colorResource(id = R.color.orange_7900),
                textAlign = TextAlign.Start
            )
            Image(modifier = Modifier.padding(start = 320.dp), painter = painterResource(id = R.drawable.icon_rightarrow), contentDescription = "")
        }
    }
}

@Composable
fun CheckBoxComponent(value: String, onTextSelected: (String) -> Unit){
    Row (modifier = Modifier
        .fillMaxWidth()
        .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        val checkedState = remember {
            mutableStateOf(false)
        }

        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it}
        )
        ClickableTextComponent(value = value, onTextSelected)
    }
}

@Composable
fun CheckBoxComponentWithTextOnly(value: String){
    Row (modifier = Modifier
        .fillMaxWidth()
        .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        val checkedState = remember {
            mutableStateOf(false)
        }

        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it}
        )
        Text(text = value)
    }
}

@Composable
fun ClickableTextComponent(value: String, onTextSelected: (String) -> Unit){
    val initialText = "By continuing you accept our "
    val privacyPolicyText = "Privacy Policy "
    val andText = "and "
    val termsAndConditionText = "Term of use"
    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = clickableBlueish)){
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = clickableBlueish)){
            pushStringAnnotation(tag = termsAndConditionText, annotation = termsAndConditionText)
            append(termsAndConditionText)
        }
    }


    ClickableText(text = annotatedString, onClick = {offset ->
        annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also { span->
                Log.d("ClickableTextComponent", "{$span}")

                if((span.item == termsAndConditionText) || (span.item == privacyPolicyText)) {
                    onTextSelected(span.item)
                }
            }

    })
}

@Composable
fun ClickableTextBelumPunyaAkunComponent(onTextSelected: (String) -> Unit){
    val initialText = "Belum Punya Akun? "
    val daftarText = "Daftar"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = clickableBlueish)){
            pushStringAnnotation(tag = daftarText, annotation = daftarText)
            append(daftarText)
        }
    }


    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString, onClick = {offset ->
        annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also { span->
                Log.d("ClickableTextComponent", "{$span}")

                if((span.item == daftarText)) {
                    onTextSelected(span.item)
                }
            }

    })
}

@Composable
fun ClickableTextSudahPunyaAkunComponent(onTextSelected: (String) -> Unit){
    val initialText = "Sudah Punya Akun? "
    val masukText = "Masuk"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = clickableBlueish)){
            pushStringAnnotation(tag = masukText, annotation = masukText)
            append(masukText)
        }
    }


    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString, onClick = {offset ->
            annotatedString.getStringAnnotations(offset,offset)
                .firstOrNull()?.also { span->
                    Log.d("ClickableTextComponent", "{$span}")

                    if((span.item == masukText)) {
                        onTextSelected(span.item)
                    }
                }

        })
}

//@Composable
//fun SwitchButton(){
//    Column (
//        modifier = Modifier.fillMaxWidth()
//    ){
//        val checkedState = remember {
//            mutableStateOf(false)
//        }
//
//        Switch(
//            checked = checkedState.value,
//            onCheckedChange ={ checkedState.value = it },
//            colors = SwitchDefaults.colors(Color.Green)
//        )
//
//        if(checkedState.value){
//            Toast.makeText(this@AppComponent, "On", Toast.LENGTH_SHORT).show()
//        }else{
//            Toast.makeText(this@AppComponent, "Off", Toast.LENGTH_SHORT).show()
//        }
//    }
//}

@Composable
fun Switches(value: String){
    
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Absolute.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        var isChecked by remember {
            mutableStateOf(false)
        }
        Text(text = value,
            modifier = Modifier.size(width = 260.dp, height = 40.dp),
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal
            ),
            color = colorResource(id = R.color.blackfont),
            textAlign = TextAlign.Start
        )


        Switch(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
            thumbContent = {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize)
                )
            }
        )
    }
}

