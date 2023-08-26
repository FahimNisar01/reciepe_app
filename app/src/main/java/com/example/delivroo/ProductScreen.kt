package com.example.delivroo

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.delivroo.ui.theme.lightBlue

@Composable
fun ProductScreen() {
    Column(
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .padding(top = 10.dp)
    ) {
        Header()
        SearchBar()
        CategoryList()
        val scrollState = rememberScrollState()
        Column(modifier = Modifier.verticalScroll(state = scrollState)) {
            FeaturedText()
            FeaturedCategoryList()
            DiscountText()
            DiscountList()
        }


    }
}

@Composable
fun DiscountList() {
    LazyRow(content = {
        items(getDiscountList()) { item ->
            FeaturedCategoryListView(image = item.image, name = item.name, location = item.location)

        }
    })
}





@Composable
fun DiscountText() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Tastly Discount",
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        )
        Image(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = null,
            colorFilter = ColorFilter.tint(
                lightBlue
            )
        )
    }
}

@Composable
fun FeaturedCategoryList() {
    LazyRow(content = {
        items(getFeaturedtList()) { item ->
            FeaturedCategoryListView(image = item.image, name = item.name, location = item.location)

        }
    })
}

@Composable
fun FeaturedText() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Featured",
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        )
        Image(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = null,
            colorFilter = ColorFilter.tint(
                lightBlue
            )
        )
    }
}

@Composable
fun CategoryList() {
    LazyRow(content = {
        items(getCategoryList()) { item ->
            CategoryListView(image = item.image, name = item.name)

        }
    })

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(horizontal = 5.dp),
            value = "",
            onValueChange = {},
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.LightGray
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = null,
                    tint = Color.LightGray
                )
            },
            placeholder = { Text(text = "Restaurants and Dishes") },
            shape = RoundedCornerShape(30.dp),


            )
        Image(
            painterResource(id = R.drawable.filter_icon),
            contentDescription = null,
            colorFilter = ColorFilter.tint(
                lightBlue
            ),
        )

    }
}

@Composable
fun Header() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier

            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Deliver now",
                style = TextStyle(
                    color = Color.LightGray,
                    fontSize = 14.sp
                )
            )
            Row {
                Text(
                    text = "Current Location",
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                )
                Image(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(
                        lightBlue
                    )
                )
            }

        }

        Image(
            imageVector = Icons.Outlined.Person,
            contentDescription = null,
            colorFilter = ColorFilter.tint(
                lightBlue
            ),
        )
    }
}

@Preview(device = Devices.PIXEL, showBackground = true, showSystemUi = true)
@Composable
fun ProductScreenPreview() {
    ProductScreen()
}