package com.example.bankapp

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun testUI(){
    val mContext = LocalContext.current
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)
        , horizontalAlignment = Alignment.Start
         , modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)) {


    Button(onClick = { myToast(mContext) }) {
        Text(text = "My Name")
    }
    Button(onClick = { myToast(mContext) }) {
        Text(text = "My SurName")
    }
    }
}

private fun myToast(context: Context){
    Toast.makeText(context,"Hello world",Toast.LENGTH_LONG).show()
}