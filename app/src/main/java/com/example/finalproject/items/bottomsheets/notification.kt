package com.example.finalproject.items.bottomsheets

import android.app.Notification
import androidx.compose.material3.*
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
fun NotificationItem(){

    var isChecked by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)
        .padding(horizontal = 16.dp)) {
        Spacer(Modifier.height(16.dp))
        TextItem(
            stringResource(R.string.notification_settings), style = TextStyle(fontWeight = FontWeight.SemiBold, color = colorResource(
            R.color.app_color), fontSize = 18.sp)
        )
        Spacer(Modifier.height(8.dp))


        Column (
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .clickable { }
                .background(colorResource(R.color.divider)),
             ) {
            Row (modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween){

                TextItem("General Push Notifications",
                    style = TextStyle(fontSize = 14.sp))
                Switch(
                    checked = isChecked,
                    onCheckedChange = { isChecked = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor =colorResource(R.color.app_color),
                        uncheckedThumbColor = colorResource(R.color.gray),
                        checkedTrackColor = Color.LightGray,
                        uncheckedTrackColor = Color.LightGray
                    )
                )

            }

            TextItem(stringResource(R.string.recieve_general_update_and_notifications), style = TextStyle(fontSize = 14.sp, color = Color.Gray), modifier = Modifier.padding(horizontal = 16.dp))

            Spacer(Modifier.height(16.dp))

        }

        Spacer(Modifier.height(16.dp))

    }
}