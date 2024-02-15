package com.example.bankapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankapp.ui.theme.BlueEnd
import com.example.bankapp.ui.theme.BlueStart
import com.example.bankapp.ui.theme.GreenEnd
import com.example.bankapp.ui.theme.GreenStart
import com.example.bankapp.ui.theme.OrangeEnd
import com.example.bankapp.ui.theme.OrangeStart
import com.example.bankapp.ui.theme.PurpleEnd
import com.example.bankapp.ui.theme.PurpleStart

val card = listOf(
    Card(
        cardName = "Business",
        cardType = "VISA",
        cardNumber = "3664 7865 3786 3976",
        balance = "46.667",
        color = getGradient(startColor = PurpleStart, endColor = PurpleEnd )
    ),
    Card(
        cardName = "School",
        cardType = "VISA",
        cardNumber = "0024 9956 2212 3976",
        balance = "10.00",
        color = getGradient(startColor = OrangeStart, endColor = OrangeEnd )
    ),
    Card(
        cardName = "Savings",
        cardType = "MASTER CARD",
        cardNumber = "2345 7558 7899 2234",
        balance = "6.667",
        color = getGradient(startColor = BlueStart, endColor = BlueEnd )
    ),

    Card(
        cardName = "Trips",
        cardType = "MASTER CARD",
        cardNumber = "5678 1267 3489 2234",
        balance = "2000",
        color = getGradient(startColor = GreenStart, endColor = GreenEnd )
    )



)


fun getGradient(startColor: Color,endColor: Color):Brush
{
    return Brush.horizontalGradient(colors = listOf(startColor,endColor))
}

@Preview
@Composable
fun CardSection(){

    LazyRow{
        items(card.size){index ->
        CardItem(index)

        }
    }
}



@Composable
fun CardItem( index:Int){

    val oneCard = card[index]
    var lastPaddingEnd = 0.dp
    if (index == card.size-1)
        lastPaddingEnd = 16.dp

    var image = painterResource(id = R.drawable.ic_visa)

    if (card[index].cardType =="MASTER CARD")
        image= painterResource(id = R.drawable.ic_mastercard)

    Box(modifier = Modifier.padding(start= 16.dp, end = lastPaddingEnd)){
        Column (
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(oneCard.color)
                .width(250.dp)
                .height(180.dp)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
             Image(painter = image, contentDescription =oneCard.cardName, modifier = Modifier.height(60.dp ))
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = oneCard.cardName, color = Color.White, fontSize = 17.sp, fontWeight = FontWeight.Bold)
            Text(text = "$ "+oneCard.balance, color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text(text = oneCard.cardNumber, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}