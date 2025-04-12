package com.example.blinkit.ui.theme.Screens

import android.graphics.Color.alpha
import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blinkit.R
import com.example.blinkit.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun bestsellercategories(modifier: Modifier){

val catergorylist = listOf<Categoryitems>(
    Categoryitems(title = "Dairy Bread &Eggs",
        imageResids = listOf(R.drawable.milk,R.drawable.img,R.drawable.pot,R.drawable.dairyproduct),
        label = "+11 more"),

            Categoryitems(title = "Vegetable & Fruits",
    imageResids = listOf(R.drawable.milk,R.drawable.img,R.drawable.pot,R.drawable.dairyproduct),
    label = "+56 more"),

    Categoryitems(title = "Oil Ghee & Masala",
        imageResids = listOf(R.drawable.milk,R.drawable.img,R.drawable.pot,R.drawable.dairyproduct),
        label = "+118 more"),

    Categoryitems(title = "Chips &Namkeen",
        imageResids = listOf(R.drawable.milk,R.drawable.img,R.drawable.pot,R.drawable.dairyproduct),
        label = "+89 more"),

    Categoryitems(title = "Atta Rice- &Dal",
        imageResids = listOf(R.drawable.milk,R.drawable.img,R.drawable.pot,R.drawable.dairyproduct),
        label = "+158 more"),

    Categoryitems(title = "Dry Fruits &Cereals",
        imageResids = listOf(R.drawable.milk,R.drawable.img,R.drawable.pot,R.drawable.dairyproduct),
        label = "+250 more")

)
    Scaffold(
        topBar = {
            TopAppBar(
                title = {}
            )
        }
    ){innerpadding->

        Column (modifier = Modifier.fillMaxSize().background(Color.White)){
            Spacer(modifier = Modifier.height(100.dp).padding(innerpadding))
            Text(
                text = "Bestsellers",
                style = Typography.titleLarge,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp),

                )
            Spacer(modifier= Modifier.padding(vertical = 5.dp))

            LazyVerticalGrid(columns = GridCells.Fixed(3),

                content = {
                        items(catergorylist){ works->
                            demoCategorie(works)
                        }
                }
            )

        }
    }


}
@Composable
fun demoCategorie(works : Categoryitems){

    Card(modifier = Modifier.size(120.dp,170.dp).padding(start = 8.dp, top = 10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray.copy(alpha = 0.3f)))
         {
        Box(  modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
            .padding(10.dp)){
            works.imageResids.getOrNull(0)?.let {
                Image(
                    painter = painterResource(id = it), contentDescription = "Milk",
                    modifier = Modifier.size(37.dp).clip(shape = RoundedCornerShape(12.dp))
                        .align(alignment = Alignment.TopStart)
                )
            }
            works.imageResids.getOrNull(1)?.let {
                Image(
                    painter = painterResource(R.drawable.img), contentDescription = "Milk",
                    modifier = Modifier.size(37.dp).align(alignment = Alignment.TopEnd)
                )
            }
            works.imageResids.getOrNull(2)?.let {
                Image(
                    painter = painterResource(R.drawable.dairyproduct), contentDescription = "Milk",
                    modifier = Modifier.size(37.dp).align(alignment = Alignment.CenterStart)
                )
            }
            works.imageResids.getOrNull(3)?.let {Image(painter = painterResource(R.drawable.pot ), contentDescription = "Milk",
                modifier = Modifier.size(37.dp).align (alignment = Alignment.CenterEnd)
            )
            }
            Text(text = works.title,
                modifier = Modifier.align (alignment = Alignment.BottomCenter).fillMaxWidth(),
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp,
                lineHeight = 18.sp,
                textAlign = TextAlign.Center)

            Card(modifier = Modifier.padding(top = 44.dp).background(color = Color.LightGray.copy(alpha = 0.2f), shape = RoundedCornerShape(6.dp)).size(44.dp,21.dp).align(alignment = Alignment.Center),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 1.dp)){
                Text(text = works.label,
                    color = Color.Black,
                    fontSize = 7.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(bottom = 5.dp, start = 2.dp)
                    )
            }





        }

    }
}

data class Categoryitems(
    val title : String,
    val imageResids: List<Int>,
    val label:String
)

@Preview(showBackground = true)
@Composable
fun demo(){
    bestsellercategories(Modifier)
}