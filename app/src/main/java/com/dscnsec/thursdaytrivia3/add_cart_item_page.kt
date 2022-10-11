package com.dscnsec.thursdaytrivia3

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*


@Composable
fun AddCartPage(){
    var isPlaying by remember {
        mutableStateOf(true)
    }
    var speed by remember {
        mutableStateOf(1f)
    }
    val composition by rememberLottieComposition(

        LottieCompositionSpec
            .RawRes(R.raw.add_anim)
    )
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever,
        isPlaying = isPlaying,
        speed = speed,
        restartOnPlay = false
    )
    Column() {
        IconButton(onClick = { /*TODO*/ }) {
            Box {
                Modifier.border(20.dp, Color.Black)
                LottieAnimation(composition = composition, progress = progress, Modifier.size(150.dp).border(20.dp, Color.Black))
            }
        }
    }
}