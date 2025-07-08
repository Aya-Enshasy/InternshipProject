package com.example.finalproject.items.bottomsheets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalproject.R
import com.example.finalproject.items.TextItem
import com.example.finalproject.model.faqs.FaqsData
import com.example.finalproject.model.policies.Data
import com.example.finalproject.viewmodel.FaqsViewModel
import com.example.finalproject.viewmodel.PoliciesViewModel

@Composable
fun PolicyBottomSheet(policiesViewModel:PoliciesViewModel= viewModel()){
    val items = policiesViewModel.items
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)
        .padding(horizontal = 16.dp)) {
        Spacer(Modifier.height(16.dp))
        TextItem(items?.title ?: stringResource(R.string.title), style = TextStyle(fontWeight = FontWeight.SemiBold, color = colorResource(R.color.app_color), fontSize = 18.sp))
        Spacer(Modifier.height(8.dp))
        TextItem(items?.description ?: "", style = TextStyle( fontSize = 14.sp))
        Spacer(Modifier.height(16.dp))

    }
}