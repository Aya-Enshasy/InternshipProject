package com.example.finalproject.items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalproject.R
import com.example.finalproject.model.SettingsModelClass

@Composable
fun RowItem(list:SettingsModelClass,show:Boolean=false, onClick: () -> Unit){
    Row(Modifier
        .fillMaxWidth()
        .clickable { onClick() }
        .clip(RoundedCornerShape(8.dp))
        .background(colorResource(R.color.light_gray)), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Row (modifier = Modifier.padding(horizontal = 16.dp, vertical =16.dp), verticalAlignment = Alignment.CenterVertically){
            if (show==true) {
                list.icon?.let { Icon(painter = it, tint = Color.Unspecified, contentDescription = "",) }
            }
            TextItem(list.text, style = TextStyle(fontSize = 14.sp), modifier = Modifier.padding(horizontal = 16.dp)) }
        Icon(painter = list.arrow, contentDescription = "", modifier = Modifier.padding(horizontal = 8.dp))

    }
    Spacer(Modifier.height(16.dp))

}