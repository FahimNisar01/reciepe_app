package com.example.delivroo

import android.content.Intent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.delivroo.ui.theme.lightBlue


@Composable
fun CategoryListView(image: Int, name: String) {
    Box(
        modifier = Modifier
            .size(115.dp)
            .padding(vertical = 15.dp, horizontal = 5.dp)
    ) {
        Image(
            painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(shape = RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop,

            )
        Text(
            text = name, style = TextStyle(color = Color.White), textAlign = TextAlign.Start,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 65.dp, start = 8.dp)
        )


    }
}

fun getCategoryList(): MutableList<CategoryData> {
    val list = mutableListOf<CategoryData>()
    list.add(CategoryData(R.drawable.pizza, "Pizza"))
    list.add(CategoryData(R.drawable.burger, "Burger"))
    list.add(CategoryData(R.drawable.sandwhich, "Sandwich"))
    list.add(CategoryData(R.drawable.pasta, "Pasta"))
    list.add(CategoryData(R.drawable.shwarma, "Shawarma"))

    return list
}

@Composable
fun FeaturedCategoryListView(image:Int,name:String,location:String) {
    val context = LocalContext.current


    Column(modifier = Modifier
        .padding(horizontal = 10.dp, vertical = 15.dp)
        .clickable {
            val intent = Intent(context, DetailsScreen::class.java)
            intent.putExtra("image", image)
            intent.putExtra("name", name)
            intent.putExtra("location", location)
            context.startActivity(
                intent
            )
        }) {
        Image(
            painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(200.dp)
                .width(250.dp)
                .clip(shape = RoundedCornerShape(15.dp)),

            )

        Text(
            text = name,
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        )

        Row {
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
fun getFeaturedtList():MutableList<FeaturedData>{
    val list= mutableListOf<FeaturedData>()
    list.add(FeaturedData(R.drawable.karahi, "Butt Karahi","(20+).Lahore.Karahi.££"))
    list.add(FeaturedData(R.drawable.biryani, "Matka Biryani","(70+).Multan.Biryani.££"))
    list.add(FeaturedData(R.drawable.hareesa, "Lohari Hareesa","(20+).Lahore.Hareesa.££"))
return list
}
fun getDiscountList():MutableList<FeaturedData>{
    val list= mutableListOf<FeaturedData>()
    list.add(FeaturedData(R.drawable.noodles, "Chinese Foods","(20+).Faislabad.Noodles.££"))
    list.add(FeaturedData(R.drawable.fish, "Doger Fish","(70+).Lahore.Grill Fish.££"))
    list.add(FeaturedData(R.drawable.bbq, "Shiekh BBQ","(40+).Lahore.BBQ.££"))
return list
}

@Preview(showSystemUi = true, device = Devices.PIXEL)
@Composable
fun Previeww() {
//    CategoryListView(R.drawable.pizza,"Pizza")
//    FeaturedCategoryListView(R.drawable.karahi,"Butt Karahi","(20+).Lahore.Karahi")
}