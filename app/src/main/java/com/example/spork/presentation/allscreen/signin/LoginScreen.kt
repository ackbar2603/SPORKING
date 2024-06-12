package com.example.spork.presentation.allscreen.signin

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.spork.R
import com.example.spork.data.local.datastore.DataStore
import com.example.spork.data.local.sharedpreferences.SharedPreferencesManager
import com.example.spork.navigation.Screen
import com.example.spork.presentation.allscreen.signin.component.EmailTextField
import com.example.spork.presentation.component.BoldTextComponent
import com.example.spork.presentation.component.ClickableTextBelumPunyaAkunComponent
import com.example.spork.presentation.component.NormalTextComponent
import com.example.spork.presentation.allscreen.signin.component.GoogleButton
import com.example.spork.presentation.allscreen.signin.component.PasswordTextField2
import com.example.spork.ui.theme.mainOrange
import com.example.spork.utils.Constant.CLIENT
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel()
){
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val state = viewModel.state.collectAsState(initial = null)
//    val sharedPreferencesManager = remember { SharedPreferencesManager(context) }
//    val dataStore = DataStore(context)
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirm by remember { mutableStateOf("") }
    var isRegistering by remember { mutableStateOf(false) }
    val googleLoginState = viewModel.stateGoogle.value


    @Suppress("DEPRECATION")
    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) {
            val account = GoogleSignIn.getSignedInAccountFromIntent(it.data)
            try{
                val result = account.getResult(ApiException::class.java)
                val credential = GoogleAuthProvider.getCredential(result.idToken, null)
                viewModel.loginWithGoogle(credential) {
                    navController.navigate(Screen.HomeScreen.route) {
                        popUpTo(Screen.Login.route) {
                            inclusive = true
                        }
                    }
                }
            } catch (it: ApiException) {
                Toast.makeText(context, "$it", Toast.LENGTH_SHORT).show()
            }
        }

    Box(modifier = Modifier.fillMaxSize()) {
        LoginContent(
            name = name,
            email = email,
            password = password,
            passwordConfirm = passwordConfirm,
            onNameChange = { name = it },
            onEmailChange = { email = it },
            onPasswordChange = { password = it },
            onPasswordConfirmChange = { passwordConfirm = it },
            onLoginClick = {
                coroutineScope.launch {
                    if (email.isBlank() || password.isBlank()) {
                        Toast.makeText(
                            context,
                            "Email dan Password wajib diisi",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        viewModel.loginUser(email, password) {
                            navController.navigate(Screen.HomeScreen.route) {
                                popUpTo(Screen.Login.route) {
                                    inclusive = true
                                }
                            }
                            email = ""
                            password = ""
                        }
                    }
                }
            },
            moveToForget = {
                Toast.makeText(
                    context,
                    "Fogot Password is still in progress",
                    Toast.LENGTH_SHORT
                ).show()
            },
            onGoogleClick = {
                val googleLogin = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestEmail()
                    .requestIdToken(CLIENT)
                    .build()

                @Suppress("DEPRECATION")
                val googleLoginClient = GoogleSignIn.getClient(context, googleLogin)
                launcher.launch(googleLoginClient.signInIntent)
            },
            onRegisterClick = {
                coroutineScope.launch {
                    if (email.isBlank() || password.isBlank()) {
                        Toast.makeText(
                            context,
                            "Email dan Password Wajib Diisi",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else if (password != passwordConfirm) {
                        Toast.makeText(
                            context,
                            "Password dan Konfirmasi Password tidak cocok",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        viewModel.registerUser(name, email, password) {
                            navController.navigate(Screen.HomeScreen.route) {
                                popUpTo(Screen.Login.route) { inclusive = true }
                            }
                            name = ""
                            email = ""
                            password = ""
                            passwordConfirm = ""
                        }
                    }
                }
            },
            toggleAuthMode = { isRegistering = !isRegistering },
            isRegistering = isRegistering,
            modifier = modifier
        )
        LaunchedEffect(key1 = state.value?.success) {
            coroutineScope.launch {
                if (state.value?.success?.isNotEmpty() == true) {
                    val success = state.value?.success
                    Toast.makeText(context, "$success", Toast.LENGTH_SHORT).show()
                }
            }
        }
        LaunchedEffect(key1 = state.value?.error) {
            coroutineScope.launch {
                if (state.value?.error?.isNotEmpty() == true) {
                    val error = state.value?.error
                    Toast.makeText(context, "$error", Toast.LENGTH_SHORT).show()
                }
            }
        }
        LaunchedEffect(key1 = googleLoginState.success) {
            coroutineScope.launch {
                if (googleLoginState.success != null) {
                    Toast.makeText(context, "Login With Google Success", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}


@Composable
fun LoginContent(
    name: String,
    email: String,
    password: String,
    passwordConfirm: String,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordConfirmChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onGoogleClick: () -> Unit,
    toggleAuthMode: () -> Unit,
    moveToForget: () -> Unit,
    isRegistering: Boolean,
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState(),
    ){
        Surface(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(24.dp)
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ){
            Spacer(modifier = Modifier.height(40.dp))

            Text( //Color for masuk or datar
                text = if (isRegistering) "Daftar" else "",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Medium,
                color = mainOrange
            )
            Image(painter = painterResource(id = R.drawable.sprorkinglogoandtext),
                contentDescription = "Sporking",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(10.dp))

            BoldTextComponent(value = stringResource(id = R.string.welcome))
            NormalTextComponent(value = stringResource(id = R.string.temukan_lapangan))

            Spacer(modifier = Modifier.height(50.dp))

            if (isRegistering){
                EmailTextField(
                    value = name,
                    onValueChange = onNameChange,
                    label = "Nama Lengkap",
                    contentDescription = "Nama Lengkap"
                )
            }
            EmailTextField(
                value = email,
                onValueChange = onEmailChange,
                label = "Email",
                contentDescription = "Email"
            )
            Spacer(modifier = Modifier.height(16.dp))
            PasswordTextField2(
                text = password,
                onValueChange = onPasswordChange,
                label = "Password"
            )
            if (isRegistering){
                PasswordTextField2(
                    text = passwordConfirm,
                    onValueChange = onPasswordConfirmChange,
                    label = "Konfirmasi Password"
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Spacer(modifier = Modifier.height(12.dp))
            // navigation for "daftar" will be here
            Row (
                modifier = modifier.height(1.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = if (isRegistering) "Sudah punya akun?" else "Belum punya akun")
                TextButton(onClick = toggleAuthMode) {
                    Text(
                        text = if (isRegistering) "Masuk" else "Daftar",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            TextButton(
                onClick = moveToForget,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Lupa Kata Sandi?")
            }

            Spacer(modifier = Modifier.height(30.dp))

            //This button is for Login
            Button(
                onClick = if (isRegistering) onRegisterClick else onLoginClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(52.dp),
                shape = RoundedCornerShape(7.dp),
                contentPadding = PaddingValues(),
                colors = ButtonDefaults.buttonColors(mainOrange)
            ){
                Text(
                    text = if (isRegistering) "Daftar" else "Masuk",
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            NormalTextComponent(value = stringResource(id = R.string.atau))
            Spacer(modifier = Modifier.height(15.dp))

            //This button is for Register using Google Account
            GoogleButton(clicked = onGoogleClick)
        }
    }
}


//@Preview
//@Composable
//fun LoginScreenPreveiw(){
//    LoginScreen(navController = rememberNavController())
//}

