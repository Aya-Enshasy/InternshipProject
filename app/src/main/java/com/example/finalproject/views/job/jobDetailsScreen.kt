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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
import com.example.finalproject.HomeBottomBarScreens
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

@OptIn( ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
 @Composable
fun JobDetailsScreen(sharedViewModel: JobSharedViewModel,navHostController: NavHostController) {
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
                .fillMaxSize()
           ,
            topBar = {
                Box(Modifier
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
                                modifier = Modifier.clickable { navHostController.popBackStack() }
                            )
                        },

                        )
                }

            },
            content = { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                        .padding(horizontal = 16.dp)
                        .verticalScroll(rememberScrollState())
                        .padding(innerPadding)
                ) {

                    Box(
                        Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp, top = 16.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(colorResource(R.color.light_gray))
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp).clickable(onClick = {
                                    navHostController.navigate(HomeBottomBarScreens.ComponyDetails.route) })
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth()
                                    ,
                                horizontalArrangement = Arrangement.End
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.purple_bookmark),
                                    contentDescription = "",
                                    tint = Color.Unspecified,
                                    modifier = Modifier.padding(horizontal = 4.dp)
                                )
                                Icon(
                                    painter = painterResource(R.drawable.green_bookmark),
                                    contentDescription = "",
                                    tint = Color.Unspecified,
                                    modifier = Modifier.padding(horizontal = 4.dp)
                                )
                                Icon(
                                    painter = painterResource(R.drawable.blue_bookmark),
                                    contentDescription = "",
                                    tint = Color.Unspecified,
                                    modifier = Modifier.padding(horizontal = 4.dp)
                                )
                            }

                            Row {
                                Icon(
                                    painter = painterResource(R.drawable.explore),
                                    contentDescription = "",
                                    tint = Color.Unspecified,
                                    modifier = Modifier.padding(end = 8.dp)
                                )
                                TextItem(job?.createTime ?: "", style = TextStyle(fontSize = 14.sp))
                            }

                            Spacer(Modifier.height(8.dp))
                            TextItem(
                                job?.title ?: "",
                                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)
                            )

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .padding(top = 16.dp, bottom = 16.dp)
                                    .fillMaxWidth()
                            ) {

                                AsyncImage(
                                    model = job?.businessMan?.imageUrl,
                                    placeholder = painterResource(R.drawable.group_50072),
                                    error = painterResource(R.drawable.group_50072),
                                    contentDescription = "Profile image of the business man",
                                    modifier = Modifier
                                        .width(36.dp)
                                        .height(36.dp)
                                        .clip(shape = RoundedCornerShape(50.dp))
                                )


                                Column(
                                    modifier = Modifier
                                        .weight(3f)
                                        .padding(horizontal = 8.dp)
                                ) {
                                    TextItem(
                                        job?.businessMan?.businessName ?: "",
                                        style = TextStyle(fontSize = 12.sp)
                                    )
                                    Row(
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        TextItem(job?.businessManId.toString(), style = TextStyle(fontSize = 12.sp))
                                        Spacer(Modifier.width(16.dp))

                                        Icon(
                                            painter = painterResource(R.drawable.icon_awesome_eye),
                                            tint = colorResource(R.color.app_color),
                                            contentDescription = ""
                                        )
                                        Spacer(Modifier.width(8.dp))
                                        TextItem(job?.watchesCount.toString(), style = TextStyle(fontSize = 12.sp))


                                    }
                                }

                                Row(Modifier.weight(1f)) {
                                    Icon(
                                        painter = painterResource(R.drawable.share),
                                        tint = Color.Unspecified,
                                        contentDescription = "",
                                        modifier = Modifier.clickable {
                                            selectedShare = true
                                            scope.launch {
                                                sheetState.show()
                                            }

                                        }
                                    )

                                    Spacer(Modifier.width(8.dp))
                                    Icon(
                                        painter = painterResource(R.drawable.book_mark),
                                        tint = Color.Unspecified,
                                        contentDescription = ""
                                    )
                                }

                            }
                        }
                    }

                    TextItem(stringResource(R.string.details), style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold))

                    DetailsItem(stringResource(R.string.job_type), job?.employmentType ?: "", icon = null)

                    DetailsItem(stringResource(R.string.work_field), job?.workField?.name.toString(), icon = null)

                    DetailsItem(stringResource(R.string.country_of_employment), job?.countryOfEmployment?.name.toString(), icon = R.drawable.money_icon)

                    DetailsItem(stringResource(R.string.salary_wage),  job?.salary.toString() ?: "0", icon = null)

                    DetailsItem(stringResource(R.string.required_experience), job?.experienceYear?.name.toString() ?: "0", icon = null)

                    Spacer(Modifier.height(24.dp))
                    TextItem(
                        stringResource(R.string.skills),
                        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    )
                    if (!job?.skills.isNullOrEmpty()) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(12.dp))
                                .padding(12.dp)
                        ) {
                            FlowRow(
                                    Modifier.padding(horizontal = 3.dp, vertical = 2.dp)
//
                            ) {
                                job?.skills?.forEach { skill ->
                                    skill?.let {
                                        Box(
                                            modifier = Modifier
                                                .background(
                                                    Color(0xFFCCEDED),
                                                    shape = RoundedCornerShape(8.dp)
                                                )
                                                .padding(horizontal = 12.dp, vertical = 8.dp)
                                        ) {
                                            Text(
                                                text = skill.name.toString(),
                                                color = Color(0xFF167D7F),
                                                fontSize = 14.sp,
                                                fontWeight = FontWeight.SemiBold
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        TextItem(stringResource(R.string.no_skills_listed), style = TextStyle(fontSize = 14.sp))
                    }


                    Spacer(Modifier.height(24.dp))

                    TextItem(
                        stringResource(R.string.job_description),
                        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    )

                    Column (modifier = Modifier
                        .fillMaxWidth()
                        .background(color = colorResource(R.color.light_gray))){
                        Text(text= job?.summary.toString() , maxLines = 3, overflow = TextOverflow.Ellipsis, modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
                        TextItem(
                            stringResource(R.string.read_more), style = TextStyle(color = colorResource(R.color.blue)),
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


                    Spacer(Modifier.height(24.dp))

                    TextItem(
                        stringResource(R.string.candidate_requirements),
                        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    )

                    Spacer(Modifier.height(8.dp))
                    DetailsItem(stringResource(R.string.nationality), job?.nationalityPrefrence?.name.toString(), icon = null)
                    DetailsItem(stringResource(R.string.country_residence), job?.countryOfResidence?.name.toString(), icon = null)
                    DetailsItem(stringResource(R.string.gender), job?.genderPerfrence.toString(), icon = null)

                    Spacer(Modifier.height(16.dp))

                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.app_color)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 8.dp,
                            pressedElevation = 12.dp,
                            focusedElevation = 10.dp
                        )
                    ) {
                        Text(stringResource(R.string.apply), fontSize = 18.sp)
                    }

                    Spacer(Modifier.height(32.dp))
                }

            }
        )

        // Show BottomSheet when item selected
        if (selectedReadMore != null) {
            ModalBottomSheet(
                onDismissRequest = {
                    selectedReadMore = null
                },
                sheetState = sheetState,
                containerColor = Color.White
            ) {
                ReadMoreBottomSheet(fullText = selectedReadMore!!)
            }
        }


        if (selectedShare) {
            ModalBottomSheet(
                onDismissRequest = {
                    selectedShare = false
                },
                sheetState = sheetState
            ) {
                ShareViaBottomSheet()
            }
        }
    }

}





