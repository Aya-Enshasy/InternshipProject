package com.example.finalproject.items.bottomsheets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalproject.items.TextItem

  @OptIn(ExperimentalMaterial3Api::class)
  @Composable
fun ReadMoreBottomSheet(fullText: String){

        Column {
            TextItem(fullText, style = TextStyle(fontSize = 14.sp), modifier = Modifier.padding(16.dp))

    }
}