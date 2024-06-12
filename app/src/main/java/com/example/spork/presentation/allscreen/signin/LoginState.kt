package com.example.spork.presentation.allscreen.signin

data class LoginState(
    val success: String? = "",
    val error: String? = "",
    val loading: Boolean = false
)