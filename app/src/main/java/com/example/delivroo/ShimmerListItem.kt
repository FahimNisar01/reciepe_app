package com.example.delivroo

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerListItem(
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    image: Int, name: String?, location: String?
) {
    if (isLoading) {
        Column(modifier = modifier) {
            Box (modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .shimmerEffect())
            Spacer(modifier = Modifier.padding(15.dp))

            Column(Modifier.padding(horizontal = 10.dp)) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.2f)
                        .height(20.dp)
                        .shimmerEffect()
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .height(15.dp)
                        .shimmerEffect()
                )
                Spacer(modifier = Modifier.padding(15.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .shimmerEffect()
                )
                Spacer(modifier = Modifier.padding(15.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.2f)
                        .height(20.dp)
                        .shimmerEffect()
                )
                Spacer(modifier = Modifier.padding(15.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(230.dp)
                        .shimmerEffect()
                )
            }




        }
    }else{
        DetailsScreenFun(image = image, name = name, location = location)
    }
}


fun Modifier.shimmerEffect(): Modifier = composed {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    val transition = rememberInfiniteTransition()
    val startOffsetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(1000)
        )
    )

    background(
        brush = Brush.linearGradient(
            colors = listOf(
                Color(0xFFB8B5B5),
                Color(0xFF8F8B8B),
                Color(0xFFB8B5B5),
            ),
            start = Offset(startOffsetX, 0f),
            end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
        )
    )
        .onGloballyPositioned {
            size = it.size
        }
}
@Preview(device = Devices.PIXEL, showSystemUi = true)
@Composable
fun ShimmerPreview(){
}