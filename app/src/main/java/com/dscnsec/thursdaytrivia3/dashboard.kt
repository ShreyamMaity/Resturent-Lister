package com.dscnsec.thursdaytrivia3

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.dscnsec.thursdaytrivia3.ui.theme.ThursdayTrivia3Theme
import com.google.firebase.firestore.FirebaseFirestore


//@SuppressLint("UnrememberedMutableState")
@Composable
fun Dashboard() {
    val data : Array<Card> = arrayOf<Card>(
        Card(
            "1",
            "KFC",
            100,
            "https://static.lexpress.fr/medias_1547/w_1936,h_1090,c_fill,g_north/v1404807535/kfc-limoges_792154.jpg",
            "Burger, Fries, Chicken",
            4.5
        ),
        Card(
            "2",
            "McDonalds",
            200,
            "https://cdn.britannica.com/64/19464-050-EE63E306/restaurant-McDonalds-museum-Ray-Kroc-Illinois-Des.jpg",
            "Burger, Fries, Chicken",
            4.5
        ),
        Card(
            "3",
            "Burger King",
            300,
            "https://live.staticflickr.com/65535/51176889476_aa620cb0ba_b.jpg",
            "Burger, Fries, Chicken",
            4.5
        )
    )
    Modifier.background( Color(0xFFf4f4f2))
    Column(modifier = Modifier
        .padding(horizontal = 15.dp, vertical = 10.dp)
        .verticalScroll(rememberScrollState()))  {
        Spacer(modifier = Modifier.height(10.dp))
        SearchBar()
        Spacer(modifier = Modifier.height(20.dp))
        data.forEach { card ->
            Cards(data = card)
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun SearchBar(){
    Row(
        modifier = Modifier
            .shadow(10.dp, RoundedCornerShape(20.dp))
            .background(Color.White, shape = RoundedCornerShape(20.dp))
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search",
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .align(Alignment.CenterVertically)
        )
        Text(
            text = "Resturent Name or a dish...",
            modifier = Modifier
//                .padding(horizontal = 20.dp, vertical = 20.dp)
                .align(Alignment.CenterVertically)
        )
    }
}

@Composable
fun Cards(data : Card){
   Column(modifier = Modifier
       .shadow(10.dp, RoundedCornerShape(20.dp))
       .background(Color.White, shape = RoundedCornerShape(20.dp))) {
         Image(
                painter = rememberAsyncImagePainter(data.image),
                contentDescription = "image",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(20.dp))
                    .height(200.dp)
                    .clip(
                        RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
                    ),
                        contentScale = ContentScale.FillWidth
                    )
       Row(modifier = Modifier
           .padding(10.dp)
           .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
           Column {
               Text(text = data.title!!, fontSize = 20.sp)
                Text(text = data.specialitis!!, fontSize = 12.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier
                        .wrapContentSize(
                            Alignment.Center,
                            unbounded = true
                        )
                        .requiredWidth(250.dp)
                        .padding(top = 5.dp,)

                )
           }
           Column {
               Box(modifier = Modifier
                   .background(Color(0xFF018786), RoundedCornerShape(20))
                   .padding(5.dp)) {
                   Row() {
                       Text(text = data.rating.toString(), fontSize = 20.sp  , color = Color.White)
                        Icon(Icons.Filled.Star, contentDescription = "star"  , tint = Color(0xFFfdd835))
                   }
               }
                Text(text = "₹${data.price.toString()} for one" , fontSize = 10.sp,
                modifier = Modifier.padding(top = 5.dp))
           }
       }
   }
}

