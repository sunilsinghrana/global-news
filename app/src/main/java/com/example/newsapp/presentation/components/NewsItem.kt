package com.example.newsapp.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.newsapp.R
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.model.News
import com.example.newsapp.presentation.navigation.Screen

@Composable
fun NewsItem(
    news : Article,
    navHostController: NavHostController,
    ) {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        modifier = Modifier
            .height(130.dp)
            .padding(horizontal = 10.dp, vertical = 8.dp)
            .clickable {
                navHostController.navigate(Screen.Detail.route + "/${news.title}/${news.description}/${news.source.name}/${news.publishedAt}/${news.content}/${news.urlToImage}")
            },
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = news.urlToImage,
//                model = "https://media.wired.com/photos/6631a1936dc0c77846852ed5/191:100/w_1280,c_limit/Crypto-Money-Laundering-Security-GettyImages-1543076825.jpg",
                contentDescription = null,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(15.dp))
                    .size(width = 100.dp, height = 100.dp),
                contentScale = ContentScale.Crop,
            )
            Column(
                modifier = Modifier
                    .height(100.dp)
                    .padding(20.dp, 2.dp, 2.dp, 2.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                        text = news.author ?: "",
//                    text = "Sunil Singh rana",
                    color = colorResource(id = R.color.black),
                    fontSize = 12.sp,
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = news.description ?: "",
//                        text = "News Text, just to show text and also to see if text is longer then how does text overflow handle it in ownway.",
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.width(170.dp),
                        maxLines = 2,
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.SemiBold,
                    )
                    Icon(
                        imageVector = Icons.Default.BookmarkBorder,
                        contentDescription = null,
                        Modifier.size(20.dp)
                    )
                }

                Text(
                        text = news.publishedAt ?: "",
//                    text = "published at 12/25/2024",
                    color = colorResource(id = R.color.black),
                    fontSize = 8.sp,
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun NewsItemPrev() {
//    NewsItem()
}