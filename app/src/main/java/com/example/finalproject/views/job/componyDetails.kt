package com.example.finalproject.views.job

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

import coil3.compose.AsyncImage
import com.example.finalproject.R
import com.example.finalproject.items.TextItem
import com.example.finalproject.items.bottomsheets.FaqsBottomSheet
import com.example.finalproject.items.bottomsheets.LanguagePreferenceBottomSheet
import com.example.finalproject.items.bottomsheets.ReadMoreBottomSheet
import com.example.finalproject.items.bottomsheets.ShareViaBottomSheet
import com.example.finalproject.items.bottomsheets.TakeActionsBottomSheet
import com.example.finalproject.items.jobs.DetailsItem
import com.example.finalproject.model.faqs.FaqsData
import com.example.finalproject.viewmodel.JobSharedViewModel
import kotlinx.coroutines.launch

@OptIn(  ExperimentalMaterial3Api::class)
 @Composable
fun ComponyDetails(sharedViewModel: JobSharedViewModel,navHostController: NavHostController) {
    val job = sharedViewModel.selectedJob

    val gradientBrush = Brush.verticalGradient(
        colors = listOf(Color(0xFF48A7A5), Color(0xFF1D9693))
    )

    val sheetState = rememberModalBottomSheetState()
    val sheetState1 = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    val scope1 = rememberCoroutineScope()
    var selectedReadMore by remember { mutableStateOf<String?>(null) }
    var selectedShare by remember { mutableStateOf(false) }


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
                                bottomStart = 20.dp,
                                topStart = 0.dp,
                                topEnd = 0.dp
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
                            .clip(
                                RoundedCornerShape(
                                    bottomEnd = 20.dp,
                                    bottomStart = 20.dp,
                                    topStart = 0.dp,
                                    topEnd = 0.dp
                                )
                            )
                            .padding(horizontal = 16.dp),
                        title = { Text(stringResource(R.string.back), color = Color.White) },
                        navigationIcon = {
                            Icon(
                                painter = painterResource(R.drawable.baseline_arrow_back_ios_24),
                                contentDescription = "",
                                tint = Color.White,
                                modifier = Modifier.clickable(onClick = {
                                    navHostController.popBackStack()
                                })
                            )
                        },
                        actions = {
                            Icon(
                                painter = painterResource(R.drawable.baseline_drag_handle_24),
                                contentDescription = "",
                                tint = Color.White,
                                modifier = Modifier.clickable (onClick = {
                                        selectedShare = true
                                    scope.launch {
                                        sheetState.show()
                                    }
                                })
                            )
                        }

                    )
                }

            },
            content = { innerPadding ->
Column(modifier = Modifier
        .fillMaxWidth()
         .padding(16.dp)
        .verticalScroll(rememberScrollState())
        .padding(innerPadding)) {


                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(16.dp))
                ) {
                     Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(260.dp)
                            .clip(RoundedCornerShape(16.dp))
                    ) {
                         AsyncImage(
                             model = job?.businessMan?.imageUrl,
                             contentScale = ContentScale.Crop,
                             placeholder = painterResource(R.drawable.group_50072),
                             error = painterResource(R.drawable.group_50072),
                             contentDescription = "",
                             modifier = Modifier
                                 .matchParentSize()
                                 .offset(y = (-40).dp)
                                 .clip(RoundedCornerShape(16.dp))
                         )
                    }

                     AsyncImage(
                        model = job?.businessMan?.imageUrl,
                        contentScale = ContentScale.Crop,
                        placeholder = painterResource(R.drawable.group_50072),
                        error = painterResource(R.drawable.group_50072),
                        contentDescription = "Profile image of the business man",
                        modifier = Modifier
                            .size(80.dp)
                            .offset(y = (-80).dp)
                            .clip(CircleShape)
                            .clip(shape = RoundedCornerShape(50.dp))
                    )

                    Text(
                        text = job?.title.toString(),
                        modifier = Modifier
                            .offset(y = (-80).dp),
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onBackground
                    )

                    Text(
                        text = job?.salaryShow.toString(),
                        fontSize = 14.sp,
                        modifier = Modifier
                            .offset(y = (-80).dp),
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
                    )
                }

                TextItem(
                    stringResource(R.string.details),
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
                )

    Spacer(Modifier.height(8.dp))

                DetailsItem(
                    stringResource(R.string.type_of_business),
                    job?.employmentType ?: "",
                    icon = null
                )

                DetailsItem(
                    stringResource(R.string.no_of_employees),
                    job?.experienceYear?.name.toString() ?: "0",
                    icon = null
                )

                DetailsItem(
                    stringResource(R.string.country_of_employment),
                    job?.countryOfEmployment?.name.toString(),
                    icon =null
                )

                Spacer(Modifier.height(24.dp))



                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = colorResource(R.color.light_gray))
                ) {
                    Text(
                        text = job?.summary.toString(),
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                    TextItem(
                        stringResource(R.string.read_more),
                        style = TextStyle(color = colorResource(R.color.blue)),
                        modifier = Modifier
                            .clickable {
                                selectedReadMore = job?.summary.toString()
                                scope.launch {
                                    sheetState.show()
                                }
                            }
                            .padding(horizontal = 16.dp))
                    Spacer(Modifier.height(8.dp))
                }


                Spacer(Modifier.height(24.dp))

            }
            }

        )}


        if (selectedShare) {
            ModalBottomSheet(
                onDismissRequest = {
                    selectedShare = false
                },
                sheetState = sheetState
            ) {
                TakeActionsBottomSheet(sheetState)
            }
        }
    }



