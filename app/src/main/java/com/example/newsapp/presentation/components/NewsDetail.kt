package com.example.newsapp.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.newsapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsDetail(
    backStackEntry: NavBackStackEntry,
    navController: NavHostController
) {
    val newsTitle = backStackEntry.arguments?.getString("newsTitle")
    val newsDescription = backStackEntry.arguments?.getString("newsDescription")
    val newsSourceName = backStackEntry.arguments?.getString("newsSourceName")
    val newsDate = backStackEntry.arguments?.getString("newsDate")
    val newsContent = backStackEntry.arguments?.getString("newsContent")
    val newsImage = backStackEntry.arguments?.getString("newsImage")

    val imageState = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(newsImage)
            .crossfade(true)
            .size(Size.ORIGINAL)
            .build()
    )


Scaffold(
    topBar = {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface,
                titleContentColor = colorResource(id = R.color.black),
            ),
            title = {
                Text(
                    text = "Article",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.black),
                    fontFamily = FontFamily.Monospace,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            navigationIcon = {
                IconButton(onClick = {
                    navController.navigateUp()
                }) {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground,
                        )
                }
            },
            )
    }
) {innerPadding ->
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
        .padding(horizontal = 5.dp)
    ){

        Spacer(modifier = Modifier.height(10.dp))

        Image(
//            model = "https://media.wired.com/photos/6631a1936dc0c77846852ed5/191:100/w_1280,c_limit/Crypto-Money-Laundering-Security-GettyImages-1543076825.jpg",
            painter = imageState,
            contentDescription = null,
            modifier = Modifier
                .height(200.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .border(BorderStroke(2.dp, Color.Gray))
            ,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Text(
                text = newsTitle ?: "",
                color = colorResource(id = R.color.black),
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Row(
                modifier = Modifier
                    .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Rounded.AccountCircle,
                    contentDescription = null
                )
                Text(
                    text = newsSourceName ?: "",
                    color = colorResource(id = R.color.black),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                )
                Text(
                    text = newsDate ?: "",
                    color = colorResource(id = R.color.black),
                    fontSize = 12.sp,
                )
            }
            Text(
                text = newsDescription ?: "",
                color = colorResource(id = R.color.black),
                fontSize = 12.sp,
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = newsContent.toString() ?: "",
                color = colorResource(id = R.color.black),
                fontSize = 12.sp,
            )
        }


    }
}

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun DetailAppBarPrev() {
//    DetailAppBar()
//    NewsDetail()
}