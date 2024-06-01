package com.example.spork.presentation.news

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.spork.R
import com.example.spork.data.DummyData
import com.example.spork.model.News
import com.example.spork.presentation.news.component.newsColumn
import com.example.spork.presentation.component.TopBar
import com.example.spork.navigation.Screen
import com.example.spork.presentation.component.BottomBar

@Composable
fun newsScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    berita: List<News> = DummyData.newsList
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "home"

    Scaffold (
        topBar = { TopBar(backButton = {null}, value = stringResource(id = R.string.none))},
        bottomBar = { BottomBar(navController = navController, currentRoute = currentRoute) }
    ){innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(innerPadding)
        ){
            LazyColumn (
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier
            ){
                items(berita, key = {it.id}){
                    newsColumn(news = it) { newsId ->
                        navController.navigate(Screen.NewsDetail.route + "/$newsId")
                    }
                }
            }
        }

    }
}

//items(berita, key = {it.id}){
//    newsColumn(news = it) { berita ->
//        navController.navigate(Screen.NewsDetail.route + "/mentorId")
//    }
//}