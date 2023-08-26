package com.example.delivroo


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import com.example.delivroo.ui.theme.DelivrooTheme
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.delivroo.ui.theme.lightBlue
import kotlinx.coroutines.delay

class DetailsScreen : ComponentActivity() {
    var image: Int = 0
    var name: String? = null
    var location: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DelivrooTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    image = intent.getIntExtra("image", R.drawable.bbq)
                    name = intent.getStringExtra("name")
                    location = intent.getStringExtra("location")
                    var isLoading = remember {
                        mutableStateOf(true)
                    }
                    
                    LaunchedEffect(key1 = true ){
                        delay(2000)
                        isLoading.value=false
                    }
                    ShimmerListItem(isLoading = isLoading.value, image =  image, name = name, location = location)


                }
            }
        }
    }
}

@Composable
fun DetailsScreenFun(image: Int, name: String?, location: String?) {
    Column() {
        UpperSection(image, name.orEmpty(), location.orEmpty())
        ExpandableText()
        DiscountList()
    }
}

@Composable
fun ExpandableText() {
    var isExpanded = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Food is more than sustenance; it's a cultural tapestry woven from flavors, traditions, and stories. With every bite, we embark on a journey through history and geography, savoring the unique identity of each dish..",
            maxLines = if (isExpanded.value) Int.MAX_VALUE else 2,
            style = TextStyle(fontSize = 16.sp)
        )

        if (!isExpanded.value) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown, // Replace with your dropdown icon
                contentDescription = null,
                tint = lightBlue,
                modifier = Modifier
                    .clickable { isExpanded.value = true }
                    .align(Alignment.End)
            )
        } else {
            AnimatedVisibility(
                visible = isExpanded.value,
                enter = slideInVertically(),
                exit = slideOutVertically()
            ) {
                Text(
                    text = "From aromatic spices in bustling markets to family recipes passed down for generations, food transcends mere nourishment to become an expression of heritage and creativity. It has the power to evoke memories, spark conversations, and unite people across cultures. As we explore diverse cuisines, we discover the artistry behind every ingredient and the symphony of tastes that dance on our palates. Food isn't just a source of energy; it's a celebration of life's rich flavors.",
                    style = TextStyle(fontSize = 16.sp)
                )
            }
            Icon(
                imageVector = Icons.Default.KeyboardArrowUp, // Replace with your up arrow icon
                contentDescription = null,
                tint = lightBlue,

                modifier = Modifier
                    .clickable { isExpanded.value = false }
                    .align(Alignment.End)
            )
        }

        Text(
            text = "Recommended",
            modifier = Modifier.padding(top = 15.dp),
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        )

    }
}


@Composable
fun UpperSection(image: Int, name: String, location: String) {
    Column {
        Box {
            val backDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
            Image(
                painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),

                contentScale = ContentScale.Crop
            )
            Image(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                colorFilter = ColorFilter.tint(
                    lightBlue
                ),
                modifier = Modifier
                    .padding(20.dp)
                    .clickable { backDispatcher?.onBackPressed() }
                    .drawBehind {
                        drawCircle(
                            color = Color.White,
                            radius = this.size.minDimension
                        )
                    },
                alignment = Alignment.TopStart
            )

        }
        Column(modifier = Modifier.padding(15.dp)) {
            Text(
                text = name,
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            )
            Row(modifier = Modifier.padding(top = 10.dp)) {
                Image(
                    imageVector = Icons.Filled.Star,
                    modifier = Modifier.size(18.dp),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(
                        Color.Green
                    )
                )
                Text(
                    text = "4.5",
                    style = TextStyle(
                        color = Color.Green,
                        fontSize = 14.sp
                    )
                )
                Text(
                    text = location,
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                )
            }

        }
    }
}

@Preview(showSystemUi = true, device = Devices.PIXEL, showBackground = true)
@Composable
fun DetailsScreenPreview() {
    DetailsScreen()
}