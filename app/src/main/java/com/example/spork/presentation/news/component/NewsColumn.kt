package com.example.spork.presentation.news.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.spork.R
import com.example.spork.model.News
import com.example.spork.ui.theme.SPORKTheme

@Composable
fun newsColumn(
    news: News,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
            .clickable {onItemClicked(news.id)}
    ){
        Card(
            modifier = Modifier
                .wrapContentSize()
                .padding(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Row (
                modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ){
                Image(painter = painterResource(id = news.newsImageID),
                    contentDescription = news.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = news.title, style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(12.dp))
                    Row {
//                Text(text = news.date)
                        Text(text = "- ${news.date}", color = Color.Gray)
                    }
                }
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun newsColumnPreview(){
    SPORKTheme {
        newsColumn(
            news = News(
                1,
                "Manchester United Shocks Manchester City in English FA Cup Final",
                "20/8/2023",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Massa massa ultricies mi quis hendrerit dolor magna. Lorem sed risus ultricies tristique nulla aliquet enim tortor. Quis auctor elit sed vulputate mi sit amet mauris.",
                R.drawable.p1
            ), onItemClicked = {newsId ->
                println("News: $newsId")
            }
        )
    }
}