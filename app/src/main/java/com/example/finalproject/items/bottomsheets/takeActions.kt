package com.example.finalproject.items.bottomsheets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalproject.R
import com.example.finalproject.items.TextItem

 @OptIn(ExperimentalMaterial3Api::class)
 @Composable
fun TakeActionsBottomSheet(sheetState: SheetState,){
    var showSheet by remember { mutableStateOf(false) }

    ModalBottomSheet(onDismissRequest = {showSheet=false}, sheetState = sheetState) {
        Column {
            TextItem(stringResource(R.string.take_action), style = TextStyle(fontSize = 16.sp, color = colorResource(R.color.app_color)), modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(Modifier.height(8.dp))

            Row(Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .padding(horizontal = 16.dp)
                .background(colorResource(R.color.light_gray)), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Row (modifier = Modifier.padding(horizontal = 16.dp, vertical =16.dp), verticalAlignment = Alignment.CenterVertically){
                    Icon(painter = painterResource(R.drawable.call), tint = Color.Unspecified, contentDescription = "")
                    TextItem(stringResource(R.string.call), style = TextStyle(fontSize = 14.sp), modifier = Modifier.padding(horizontal = 8.dp)) }
                Icon(painter = painterResource(R.drawable.baseline_keyboard_arrow_right_24), contentDescription = "")

            }
            Spacer(Modifier.height(8.dp))


            Row(Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .padding(horizontal = 16.dp)
                .background(colorResource(R.color.light_gray)), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Row (modifier = Modifier.padding(horizontal = 16.dp, vertical =16.dp), verticalAlignment = Alignment.CenterVertically){
                    Icon(painter = painterResource(R.drawable.text), tint = Color.Unspecified, contentDescription = "")
                    TextItem(stringResource(R.string.send_sms), style = TextStyle(fontSize = 14.sp), modifier = Modifier.padding(horizontal = 8.dp)) }
                Icon(painter = painterResource(R.drawable.baseline_keyboard_arrow_right_24), contentDescription = "")

            }
            Spacer(Modifier.height(8.dp))



            Row(Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .padding(horizontal = 16.dp)
                .background(colorResource(R.color.light_gray)), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Row (modifier = Modifier.padding(horizontal = 16.dp, vertical =16.dp), verticalAlignment = Alignment.CenterVertically){
                    Icon(painter = painterResource(R.drawable.icon_awesome_whatsapp_square), tint = Color.Unspecified, contentDescription = "")
                    TextItem(stringResource(R.string.whatsapp), style = TextStyle(fontSize = 14.sp), modifier = Modifier.padding(horizontal = 8.dp)) }
                Icon(painter = painterResource(R.drawable.baseline_keyboard_arrow_right_24), contentDescription = "")

            }
            Spacer(Modifier.height(8.dp))



        }
    }
}