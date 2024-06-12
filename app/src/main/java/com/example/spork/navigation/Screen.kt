package com.example.spork.navigation


sealed class Screen (val route: String){
    data object Welcome: Screen("welcome")
    data object SignIn: Screen("sign_in")
    data object SignUp: Screen("sign_up")
    data object Login: Screen("login")
    data object Splash: Screen("splash")

    //New Part
    data object HomeScreen: Screen("home")
    data object BerandaScreen: Screen("beranda")
    data object LapanganScreen: Screen("lapangan")
    data object BookingScreen: Screen("booking")

    //New Part
    data object Agreement: Screen("agreement")

    //News Screen
    data object NewsDetail: Screen("news_detail")
    data object NewsScreen: Screen("news_screen")

    //Profile Part
    data object ProfileScreen: Screen("profile_screen")
    data object ChangePasswordScreen: Screen("change_password")
    data object AccountScreen: Screen("account_screen")
    data object SecurityNotify: Screen("security_notify")

    //Community Part
    data object CommunityScreen: Screen("community")
    data object NewCommunityScreen: Screen("new_community")
}
