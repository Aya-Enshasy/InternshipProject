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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalproject.R
import com.example.finalproject.model.SettingsModelClass
import com.example.finalproject.model.faqs.FaqsData

@Composable
fun FaqsItem(faqsData: FaqsData, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(colorResource(R.color.light_gray))
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .clickable { onClick() },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextItem(
            faqsData.title,
            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier.padding(end = 16.dp)
        )
        Icon(
            painter = painterResource(R.drawable.baseline_keyboard_arrow_right_24),
            contentDescription = "",
            modifier = Modifier.padding(start = 8.dp)
        )
    }
    Spacer(Modifier.height(16.dp))
}
