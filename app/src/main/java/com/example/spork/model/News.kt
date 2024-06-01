package com.example.spork.model

import java.sql.Date

data class News(
    val id: Int,
    val title: String,
    val date: String,
    val newsItemText: String,
    val newsImageID: Int = 0
)
