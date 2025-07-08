package com.example.finalproject.items

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

 @Composable
fun TextItem(text:String, style:TextStyle,modifier: Modifier?=Modifier){

     modifier?.let {
         Text(
         text = text,
             style = style,
         modifier = it
         )
     }
}
