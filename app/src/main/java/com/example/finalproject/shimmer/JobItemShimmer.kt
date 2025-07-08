package com.example.finalproject.shimmer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.finalproject.HomeBottomBarScreens
import com.example.finalproject.model.JobModelClass
import com.example.finalproject.R
import com.example.finalproject.items.TextItem
import com.example.finalproject.model.alljobs.AllJobsData
import com.example.finalproject.model.alljobs.Skill
import com.example.finalproject.viewmodel.AllJobsViewModel
import com.example.finalproject.viewmodel.JobSharedViewModel
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer

@Preview(showBackground = true)
@Composable
fun JobItemShimmer() {
    Box(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(colorResource(R.color.light_gray))) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                repeat(3) {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .padding(horizontal = 4.dp)
                            .placeholder(visible = true, highlight = PlaceholderHighlight.shimmer())
                    )
                }
            }


            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .placeholder(visible = true, highlight = PlaceholderHighlight.shimmer())
                )
                Spacer(Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .height(14.dp)
                        .width(80.dp)
                        .placeholder(visible = true, highlight = PlaceholderHighlight.shimmer())
                )
            }

            Spacer(Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .height(18.dp)
                    .fillMaxWidth(0.5f)
                    .placeholder(visible = true, highlight = PlaceholderHighlight.shimmer())
            )

            Spacer(Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .placeholder(visible = true, highlight = PlaceholderHighlight.shimmer())
                )

                Column(
                    modifier = Modifier
                        .weight(3f)
                        .padding(horizontal = 8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .height(12.dp)
                            .width(100.dp)
                            .placeholder(visible = true, highlight = PlaceholderHighlight.shimmer())
                    )
                    Spacer(Modifier.height(4.dp))
                    Row {
                        Box(
                            modifier = Modifier
                                .height(12.dp)
                                .width(60.dp)
                                .placeholder(visible = true, highlight = PlaceholderHighlight.shimmer())
                        )
                        Spacer(Modifier.width(16.dp))
                        Box(
                            modifier = Modifier
                                .size(12.dp)
                                .placeholder(visible = true, highlight = PlaceholderHighlight.shimmer())
                        )
                        Spacer(Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .height(12.dp)
                                .width(40.dp)
                                .placeholder(visible = true, highlight = PlaceholderHighlight.shimmer())
                        )
                    }
                }

                Row(Modifier.weight(1f)) {
                    repeat(2) {
                        Box(
                            modifier = Modifier
                                .size(16.dp)
                                .padding(horizontal = 4.dp)
                                .placeholder(visible = true, highlight = PlaceholderHighlight.shimmer())
                        )
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            repeat(2) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    repeat(2) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                                .height(32.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .background(Color.White)
                                .padding(vertical = 8.dp)
                                .placeholder(visible = true, highlight = PlaceholderHighlight.shimmer())
                        )
                        Spacer(Modifier.width(16.dp))
                    }
                }
                Spacer(Modifier.height(8.dp))
            }

            Box(
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth()
                    .placeholder(visible = true, highlight = PlaceholderHighlight.shimmer())
            )

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(3) {
                    Box(
                        modifier = Modifier
                            .height(32.dp)
                            .width(80.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(colorResource(R.color.light_cyan))
                            .placeholder(visible = true, highlight = PlaceholderHighlight.shimmer())
                    )
                }
            }

            HorizontalDivider(
                Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .padding(horizontal = 8.dp)
                    .background(colorResource(R.color.divider))
            )

            Spacer(Modifier.height(8.dp))

            Row(Modifier.padding(vertical = 8.dp)) {
                Box(
                    modifier = Modifier
                        .height(14.dp)
                        .width(60.dp)
                        .placeholder(visible = true, highlight = PlaceholderHighlight.shimmer())
                )
                Spacer(Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .height(14.dp)
                        .width(100.dp)
                        .placeholder(visible = true, highlight = PlaceholderHighlight.shimmer())
                )
            }
        }
    }
}

