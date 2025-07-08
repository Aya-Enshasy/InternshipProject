package com.example.finalproject.items.jobs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalproject.R

 @Composable
fun DetailsItem(title:String,details:String,icon:Int?){
Row(horizontalArrangement = Arrangement.SpaceBetween,
    modifier = Modifier.fillMaxWidth().clip(shape = RoundedCornerShape(8.dp))
        .background(colorResource(R.color.light_gray))
        .padding(vertical = 16.dp, horizontal = 16.dp)) {
    Text(title, style = TextStyle(fontSize = 12.sp, color = colorResource(R.color.app_color)))
    Row {
     icon?.let { painterResource(it) }?.let { Icon(painter = it, contentDescription = "",Modifier.padding(horizontal = 4.dp)) }
        Text(details, style = TextStyle(fontSize = 12.sp, color = colorResource(R.color.black)))

    }
}
     Spacer(Modifier.height(8.dp))
}