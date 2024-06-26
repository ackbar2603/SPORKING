package com.example.spork

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.spork.presentation.allscreen.news.newsDetailScreen
import com.example.spork.presentation.allscreen.news.newsScreen
import com.example.spork.presentation.allscreen.signin.signInScreen
import com.example.spork.presentation.allscreen.signup.signUpScreen
import com.example.spork.presentation.allscreen.testing.agreementScreen
import com.example.spork.presentation.allscreen.welcome.welcomeScreen
import com.example.spork.navigation.Screen
import com.example.spork.presentation.allscreen.community.communityScreen
import com.example.spork.presentation.allscreen.community.newCommunityScreen
import com.example.spork.presentation.homeScreen
import com.example.spork.presentation.allscreen.profile.component.accountScreenProfile
import com.example.spork.presentation.allscreen.profile.component.changePasswordScreen
import com.example.spork.presentation.allscreen.profile.component.notifySecurityScreen
import com.example.spork.presentation.allscreen.profile.profileScreen
import com.example.spork.presentation.allscreen.signin.LoginScreen
import com.example.spork.presentation.allscreen.welcome.SplashScreen


@Composable
fun sporkingPostOfficeApp(
    navController: NavHostController = rememberNavController()
){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route
        ){
            composable(Screen.Splash.route){
                SplashScreen(navController)
            }
            composable(Screen.Welcome.route){
                welcomeScreen(navController)
            }
            composable(Screen.Login.route){
                LoginScreen(navController)
            }
            composable(Screen.SignIn.route){
                LoginScreen(navController)
            }
            composable(Screen.SignUp.route){
                signUpScreen(navController)
            }
            composable(Screen.HomeScreen.route){
                homeScreen(navController)
            }
            composable(Screen.NewsScreen.route){
                newsScreen(navController)
            }
            composable(
                Screen.NewsDetail.route + "/{berita}",
                arguments = listOf(navArgument("berita") {type = NavType.IntType})
                ){navBackStackEntry ->
                newsDetailScreen(
                    navController = navController,
                    berita = navBackStackEntry.arguments?.getInt("berita")
                )
            }

            //profile navigation
            composable(Screen.ProfileScreen.route){
                profileScreen(navController)
            }
            composable(Screen.AccountScreen.route){
                accountScreenProfile(navController)
            }
            composable(Screen.ChangePasswordScreen.route){
                changePasswordScreen(navController)
            }
            composable(Screen.SecurityNotify.route){
                notifySecurityScreen(navController)
            }

            //Community
            composable(Screen.CommunityScreen.route){
                communityScreen(navController)
            }
            composable(Screen.NewCommunityScreen.route){
                newCommunityScreen(navController)
            }


            //This composable screen is for testing purposes only
            composable(Screen.Agreement.route){
                agreementScreen()
            }
        }
    }
}


@Composable
@Preview
fun sporkingPostOfficeAppPreview(){
    sporkingPostOfficeApp()
}