package com.example.finalproject.views.homebottombar


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.finalproject.R
import com.example.finalproject.viewmodel.BottomBarViewModel
import com.example.finalproject.viewmodel.JobSharedViewModel
import com.example.finalproject.views.bookmark.BookMarksScreen
 import com.example.finalproject.views.job.JobsScreen
import com.example.finalproject.views.profile.ProfileScreen
import com.example.finalproject.views.settings.SettingsScreen

@Composable
fun CustomBottomBar(
    modifier: Modifier = Modifier,
    items: List<Pair<String, Int>>,
    selectedIndex: Int,
    onItemClick: (Int) -> Unit
) {


    Row(
        modifier = modifier
            .fillMaxWidth()
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(0.dp))
            .background(colorResource(R.color.app_color) )
           ,
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEachIndexed { index, item ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                 if (index == selectedIndex) {
                    Box(
                        modifier = Modifier
                            .width(36.dp)
                            .height(4.dp)
                            .background(Color.White)
                    )
                 }

                BottomBarItem(
                    text = item.first,
                    icon = item.second,
                     onClick = { onItemClick(index) }
                )
            }
        }}}

@Composable
fun BottomBarItem(
    text: String,
    icon: Int,
     onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(12.dp)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },)
            {
                onClick() }
    ) {
         Icon(
            painter = painterResource(icon),
            contentDescription = null,
            tint =  colorResource(R.color.white),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text,
            textAlign = TextAlign.Center,
            color =    colorResource(R.color.white),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun HomeBottomBarScreens(
    navController: NavHostController,
    sharedViewModel: JobSharedViewModel,
    bottomBarViewModel: BottomBarViewModel = viewModel()
) {
    val selectedIndex by remember { derivedStateOf { bottomBarViewModel.selectedIndex } }

    Scaffold(
        bottomBar = {
            CustomBottomBar(
                items = listOf(
                    stringResource(R.string.jobs)    to R.drawable.job,
                    stringResource(R.string.BookMarks) to R.drawable.white_bookmark,
                    stringResource(R.string.Settings) to R.drawable.icon_material_settings,
                    stringResource(R.string.Profile) to R.drawable.profile_icon,
                ),
                selectedIndex = selectedIndex,
                onItemClick = { bottomBarViewModel.selectedIndex = it },
                modifier = Modifier.fillMaxWidth().navigationBarsPadding()
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            when (selectedIndex) {
                0 -> JobsScreen(navcontroller = navController, sharedViewModel = sharedViewModel)
                1 -> BookMarksScreen(navController)
                2 -> SettingsScreen(navController)
                3 -> ProfileScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
//    HomeBottomBarScreens()
}