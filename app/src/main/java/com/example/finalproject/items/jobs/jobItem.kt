package com.example.finalproject.items.jobs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.finalproject.HomeBottomBarScreens
import com.example.finalproject.model.JobModelClass
import com.example.finalproject.R
import com.example.finalproject.items.TextItem
import com.example.finalproject.items.bottomsheets.ShareViaBottomSheet
import com.example.finalproject.model.alljobs.AllJobsData
import com.example.finalproject.model.alljobs.Skill
import com.example.finalproject.viewmodel.AllJobsViewModel
import com.example.finalproject.viewmodel.JobSharedViewModel
import kotlinx.coroutines.launch
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.ui.res.stringResource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JobItem(allJobsData: AllJobsData,navController: NavHostController,sharedViewModel: JobSharedViewModel) {
    val sheetState = rememberModalBottomSheetState()
     val scope = rememberCoroutineScope()
     var selectedShare by remember { mutableStateOf(false) }

    Box(
        Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .clickable(onClick = {
                sharedViewModel.setJob(allJobsData)
                navController.navigate(HomeBottomBarScreens.JobsDetails.route)
            })
            .clip(shape = RoundedCornerShape(16.dp))
            .background(colorResource(R.color.light_gray))

    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
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
                TextItem(allJobsData.createTime, style = TextStyle(fontSize = 14.sp))
            }

            Spacer(Modifier.height(8.dp))
            TextItem(
                allJobsData.title,
                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
            ) {

                AsyncImage(
                    model = allJobsData?.businessMan?.imageUrl,
                    placeholder = painterResource(R.drawable.group_50072),
                    error = painterResource(R.drawable.group_50072),
                    contentDescription = "Profile image of the business man",
                    modifier = Modifier
                        .width(36.dp)
                        .height(36.dp)
                        .clip(shape = RoundedCornerShape(50.dp))
                )

                Column(modifier = Modifier
                    .weight(3f)
                    .padding(horizontal = 8.dp)) {
                    TextItem(allJobsData.title, style = TextStyle(fontSize = 12.sp))
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextItem(allJobsData.businessManId.toString(), style = TextStyle(fontSize = 12.sp))
                        Spacer(Modifier.width(16.dp))

                        Icon(
                            painter = painterResource(R.drawable.icon_awesome_eye),
                            tint = colorResource(R.color.app_color),
                            contentDescription = ""
                        )
                        Spacer(Modifier.width(8.dp))
                        TextItem(allJobsData.watchesCount.toString(), style = TextStyle(fontSize = 12.sp))


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

            Spacer(Modifier.height(16.dp))

            Column {
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(Color.White)
                            .padding(vertical = 16.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.iconfinder),
                            contentDescription = "",
                            Modifier.padding(horizontal = 8.dp),
                            tint = Color.Unspecified,
                        )
                        TextItem(allJobsData.workField.name.toString(), style = TextStyle(fontSize = 12.sp))
                    }
                    Spacer(Modifier.width(16.dp))
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(Color.White)
                            .padding(vertical = 16.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.money_icon),
                            contentDescription = "",
                            Modifier.padding(horizontal = 8.dp),
                            tint = Color.Unspecified,
                        )
                        TextItem(allJobsData.salary?: "0", style = TextStyle(fontSize = 12.sp))
                    }


                }

                Spacer(Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(Color.White)
                            .padding(vertical = 16.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.star_job),
                            contentDescription = "",
                            Modifier.padding(horizontal = 8.dp),
                            tint = Color.Unspecified,
                        )
                        TextItem(allJobsData.experienceYear.name.toString(), style = TextStyle(fontSize = 12.sp))
                    }
                    Spacer(Modifier.width(16.dp))
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(Color.White)
                            .padding(vertical = 16.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.time),
                            contentDescription = "",
                            Modifier.padding(horizontal = 8.dp),
                            tint = Color.Unspecified,
                        )
                        TextItem(allJobsData.createTime.toString(), style = TextStyle(fontSize = 12.sp))
                    }


                }
            }

            Spacer(Modifier.height(16.dp))

            TextItem(allJobsData.summary, style = TextStyle(fontSize = 12.sp))


            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(allJobsData.skills) { skill ->
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(color = colorResource(R.color.light_cyan))
                            .padding(vertical = 16.dp, horizontal = 24.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        TextItem(skill.name.toString(), style = TextStyle(fontSize = 12.sp))
                    }
                }
            }

            HorizontalDivider(
                Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .padding(horizontal = 8.dp)
                    .background(
                        colorResource(R.color.divider)
                    ))

            Spacer(Modifier.height(8.dp))

            Row (Modifier.padding(vertical = 8.dp)){
                TextItem(stringResource(R.string.expire_in), style = TextStyle(fontSize = 14.sp) )
                TextItem(allJobsData.expireDate.toString(), style = TextStyle(fontSize = 14.sp) )
            }
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