package com.example.bankapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Cases
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material3.Icon
import androidx.compose.material3.Text


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankapp.ui.theme.BlueStart
import com.example.bankapp.ui.theme.OrangeStart

val financeList = listOf(
    Finance(
        icon = Icons.Rounded.StarHalf,
        name = "My\nBusiness",
        backGround = OrangeStart
    ),
    Finance(
        icon = Icons.Rounded.Cases,
        name = "My\nWallet",
        backGround = BlueStart
    ),
    Finance(
        icon = Icons.Rounded.StarHalf,
        name = "Finance\nAnalytics",
        backGround = OrangeStart
    ),
    Finance(
        icon = Icons.Rounded.MonetizationOn,
        name = "My\nTransaction",
        backGround = OrangeStart
    )

    )



@Preview
@Composable
fun FinanceSection(){
    Column {
        Text(
            text = "Finance",
            fontSize = 24.sp,
            color = androidx.compose.material3.MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        
        LazyRow{
            items(financeList.size){ index ->

                financeItem(index)
            }
        }
    }
}
@Composable
fun financeItem(int: Int){
val finance = financeList[int]
var lastPaddingEnd = 0.dp
if (int == financeList.size-1)
    lastPaddingEnd = 16.dp
   Box (modifier = Modifier.padding(start = 16.dp, end = lastPaddingEnd)){


Column(
    modifier = Modifier
        .clip(RoundedCornerShape(25.dp))
        .background(androidx.compose.material3.MaterialTheme.colorScheme.secondaryContainer)
        .size(120.dp)
        .clickable { }
        .padding(13.dp)
    , verticalArrangement = Arrangement.SpaceBetween
        )
{
       Box (
           modifier = Modifier
               .clip(RoundedCornerShape(16.dp))
               .background(finance.backGround)
               .padding(6.dp)
       ){
                Icon(imageVector = finance.icon, contentDescription = finance.name, tint = Color.White )
       }
  Text(
      text = finance.name,
      color = MaterialTheme.colorScheme.onSecondaryContainer,
      fontSize = 15.sp,
      fontWeight = FontWeight.SemiBold
  )
}
   }
}