package com.example.finalproject.views.job

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
 import androidx.compose.ui.tooling.preview.Preview
 import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.finalproject.model.JobModelClass
import com.example.finalproject.R
import com.example.finalproject.items.TextItem
import com.example.finalproject.items.jobs.JobItem
import com.example.finalproject.shimmer.JobItemShimmer
import com.example.finalproject.viewmodel.AllJobsViewModel
import com.example.finalproject.viewmodel.JobSharedViewModel

@Composable
fun JobsScreen(viewModel: AllJobsViewModel=viewModel(),navcontroller: NavHostController  , sharedViewModel: JobSharedViewModel) {
    val items = viewModel.items
    val isLoading = viewModel.isLoading
    val errorMessage = viewModel.errorMessage

    Scaffold(modifier = Modifier.padding(horizontal = 16.dp)) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextItem(
                    stringResource(R.string.fursati),
                    style = TextStyle(
                        color = colorResource(R.color.app_color),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                    )
                )

                Row {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.search),
                            contentDescription = ""
                        )
                    }

                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.icon_feather_filter),
                            contentDescription = ""
                        )
                    }

                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.icon_notification),
                            contentDescription = ""
                        )
                    }
                }
            }

            Spacer(Modifier.height(8.dp))

            TextItem(
                stringResource(R.string.welcome),
                style = TextStyle(
                    color = colorResource(R.color.gray),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
            )

            Spacer(Modifier.height(12.dp))
            TextItem(
                stringResource(R.string.mr_mam_visitor),
                style = TextStyle(
                    color = colorResource(R.color.app_color),
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                )
            )


//            LazyColumn(Modifier.fillMaxSize()) {
//                items(items){ list->JobItem(list, navController = navcontroller,sharedViewModel = sharedViewModel) }
//             }

            LazyColumn(Modifier.fillMaxSize()) {
                if (isLoading) {
                    // عرض 5 عناصر shimmer أثناء التحميل
                    items(5) {
                        JobItemShimmer()
                    }
                } else if (items.isNotEmpty()) {
                    items(items) { job ->
                        JobItem(job, navController = navcontroller, sharedViewModel = sharedViewModel)
                    }
                } else if (!errorMessage.isNullOrBlank()) {
                    item {
                        TextItem(
                            text = "Error: $errorMessage",
                            style = TextStyle(color = colorResource(R.color.purple))
                        )
                    }
                } else {
                    item {
                        TextItem(text = stringResource(R.string.no_jobs_available), style = TextStyle(color = colorResource(R.color.gray)))
                    }
                }
            }


        }
    }

}