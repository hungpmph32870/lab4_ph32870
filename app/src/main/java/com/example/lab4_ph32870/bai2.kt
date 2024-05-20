package com.example.lab4_ph32870

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class bai2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val images = listOf(R.drawable.image1, R.drawable.image2,
                R.drawable.image3)
            Column {
                Icon(painter = painterResource(id = R.drawable.logo), contentDescription = "logo")
                HorizontalImageList(images)
                VerticalImageList(images)
            }
        }
    }

    @Composable
    fun HorizontalImageList(imageList: List<Int>){
        val scrollState = rememberScrollState()
        Row (
            modifier = Modifier
                .horizontalScroll(scrollState)
                .padding(16.dp)
        ){
            imageList.forEachIndexed { index, image ->
                Image(painter = painterResource(id = image), contentDescription = " Image",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .padding(start = if (index == 0) 0.dp else 8.dp, end = 8.dp))
            }
        }
    }

    @Composable
    fun VerticalImageList(imageList: List<Int>){
        val scrollState = rememberScrollState()
        Column(modifier = Modifier
            .verticalScroll(scrollState)
            .padding(16.dp)) {
            imageList.forEachIndexed { index, image ->
                Image(painter = painterResource(id = image), contentDescription = "Image",
                    contentScale = ContentScale.FillWidth, modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .padding(top = if (index == 0) 0.dp else 8.dp, bottom = 8.dp))
            }
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun PreviewHorizontalImageList() {
        HorizontalImageList(listOf(R.drawable.image1, R.drawable.image2,
            R.drawable.image3))
    }
    @Preview(showBackground = true)
    @Composable
    fun PreviewVerticalImageList() {
        VerticalImageList(listOf(R.drawable.image1, R.drawable.image2,
            R.drawable.image3))
    }
}