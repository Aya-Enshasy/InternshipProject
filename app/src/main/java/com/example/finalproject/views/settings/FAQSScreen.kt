package com.example.finalproject.views.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.finalproject.R
import com.example.finalproject.items.FaqsItem
import com.example.finalproject.items.RowItem
import com.example.finalproject.items.bottomsheets.FaqsBottomSheet
import com.example.finalproject.model.SettingsModelClass
import com.example.finalproject.model.faqs.FaqsData
import com.example.finalproject.viewmodel.FaqsViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FAQSScreen(viewModel: FaqsViewModel = viewModel(),navController: NavHostController) {
    val items = viewModel.items
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(Color(0xFF48A7A5), Color(0xFF1D9693))
    )

    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var selectedFaq by remember { mutableStateOf<FaqsData?>(null) }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
            .background(Color.White)
    ) {
        Scaffold(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize(),
            topBar = {
                Box(
                    Modifier
                        .clip(
                            RoundedCornerShape(
                                bottomEnd = 20.dp,
                                bottomStart = 20.dp
                            )
                        )
                        .height(64.dp)
                        .background(brush = gradientBrush)
                ) {
                    TopAppBar(
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color.Transparent,
                            titleContentColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        title = { Text(stringResource(R.string.faqs), color = Color.White) },
                        navigationIcon = {
                            Icon(
                                painter = painterResource(R.drawable.baseline_arrow_back_ios_24),
                                contentDescription = "",
                                tint = Color.White,
                                modifier = Modifier.clickable(onClick = {  navController.popBackStack() })
                            )
                        }
                    )
                }
            },
            content = { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                        .padding(horizontal = 16.dp)
                        .padding(innerPadding)
                ) {
                    Spacer(Modifier.height(16.dp))

                    LazyColumn(Modifier.fillMaxSize()) {
                        items(items) { list ->
                            FaqsItem(list, onClick = {
                                selectedFaq = list
                                scope.launch {
                                    sheetState.show()
                                }
                            })
                        }
                    }
                }
            }
        )

        // Show BottomSheet when item selected
        if (selectedFaq != null) {
            ModalBottomSheet(
                onDismissRequest = {
                    selectedFaq = null
                },
                sheetState = sheetState,
                containerColor = Color.White
            ) {
                FaqsBottomSheet(faqData = selectedFaq!!)
            }
        }
    }
}
