package com.example.spork.navigation


sealed class Screen (val route: String){
    data object Welcome: Screen("welcome")
    data object SignIn: Screen("sign_in")
    data object SignUp: Screen("sign_up")

    //New Part
    data object HomeScreen: Screen("home")
    data object BerandaScreen: Screen("beranda")
    data object LapanganScreen: Screen("lapangan")
    data object BookingScreen: Screen("booking")
    data object CommunityScreen: Screen("community")
    //New Part
    data object Agreement: Screen("agreement")
    data object NewsDetail: Screen("news_detail")
    data object NewsScreen: Screen("news_screen")
    data object ProfileScreen: Screen("profile_screen")
}