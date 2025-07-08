package com.example.finalproject.items.bottomsheets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalproject.R
import com.example.finalproject.items.TextItem

@Preview(showBackground = true)
@Composable
fun LanguagePreferenceBottomSheet(){

    var selectedRow by remember { mutableStateOf("0") }

    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)
        .padding(horizontal = 16.dp)) {
        Spacer(Modifier.height(16.dp))
        TextItem(stringResource(R.string.language_preference), style = TextStyle(fontWeight = FontWeight.SemiBold, color = colorResource(R.color.app_color), fontSize = 18.sp))
        Spacer(Modifier.height(8.dp))


        Row(Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .clickable { selectedRow == "1" }
            .background(colorResource(R.color.white)), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Row (modifier = Modifier.padding( vertical =8.dp), verticalAlignment = Alignment.CenterVertically){
                Image(painter = painterResource(R.drawable.arabic) , contentDescription = "", modifier = Modifier
                    .size(64.dp)
                    .padding(horizontal = 8.dp))
                TextItem(stringResource(R.string.arabic), style = TextStyle(fontSize = 14.sp), modifier = Modifier.padding(horizontal = 16.dp)) }
            if (selectedRow=="1")
            Icon(painter = painterResource(R.drawable.baseline_check_24), contentDescription = "", tint = colorResource(R.color.app_color), modifier = Modifier.padding(horizontal = 8.dp))

        }

        Row(Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .clickable { selectedRow == "0" }
            .background(colorResource(R.color.white)), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Row (modifier = Modifier.padding( vertical =8.dp), verticalAlignment = Alignment.CenterVertically){
                Image(painter = painterResource(R.drawable.english) , contentDescription = "", modifier = Modifier
                    .size(64.dp)
                    .padding(horizontal = 8.dp))
                TextItem(stringResource(R.string.english), style = TextStyle(fontSize = 14.sp), modifier = Modifier.padding(horizontal = 16.dp)) }
           if (selectedRow=="0")
            Icon(painter = painterResource(R.drawable.baseline_check_24), contentDescription = "", tint = colorResource(R.color.app_color), modifier = Modifier.padding(horizontal = 8.dp))

        }
    }
}