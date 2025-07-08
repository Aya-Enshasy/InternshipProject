package com.example.finalproject.items.bottomsheets

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalproject.R
import com.example.finalproject.items.TextItem

@Composable
fun ShareViaBottomSheet(){
    val context = LocalContext.current

    Column {
                TextItem(
                    stringResource(R.string.share_via), style = TextStyle(fontSize = 16.sp, color = colorResource(R.color.app_color)),
                    modifier = Modifier.padding(horizontal = 16.dp))
                Spacer(Modifier.height(8.dp))

                Row (horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()){
                    Column(Modifier.clickable(onClick = {
                        val intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("aenshasy1@smail.ucas.edu.ps")
                        putExtra(Intent.EXTRA_SUBJECT, "Hello Email")
                    }
                        if (intent.resolveActivity(context.packageManager) != null) {
                            context.startActivity(intent)
                        }})){
                        Image(painter = painterResource(R.drawable.gmail,), contentDescription = "", modifier = Modifier.size(45.dp))
                        Spacer(Modifier.height(8.dp))
                        TextItem(stringResource(R.string.gmail), style = TextStyle(fontSize = 14.sp))
                        Spacer(Modifier.height(32.dp))
                    }

                    Column(Modifier.clickable(onClick = {
                            val facebook = Intent(Intent.ACTION_SENDTO).apply {
                                data = Uri.parse("mhttps://www.facebook.com/")
                                putExtra(Intent.EXTRA_SUBJECT, "Hello")
                             }
                            if (facebook.resolveActivity(context.packageManager) != null) {
                                context.startActivity(facebook)
                            }}))
                    {
                        Image(painter = painterResource(R.drawable.facebook,), contentDescription = "", modifier = Modifier.size(45.dp))
                        Spacer(Modifier.height(8.dp))
                        TextItem(stringResource(R.string.facebook), style = TextStyle(fontSize = 14.sp))
                        Spacer(Modifier.height(32.dp))
                    }

                    Column(Modifier.clickable(onClick = {
                            val messengerIntent = Intent(Intent.ACTION_VIEW).apply {
                                val userId = "ayaenshasy" // Replace with Facebook numeric ID or username
                                data = Uri.parse("fb-messenger://user/$userId")
                            }
                            try {
                                context.startActivity(messengerIntent)
                            } catch (e: Exception) {
                                // If Messenger isn't installed, open in browser
                                val fallbackIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://m.me/USERNAME"))
                                context.startActivity(fallbackIntent)
                            }
                        }
                        )) {
                        Image(painter = painterResource(R.drawable.messanger,), contentDescription = "", modifier = Modifier.size(45.dp))
                        Spacer(Modifier.height(8.dp))
                        TextItem(stringResource(R.string.messenger), style = TextStyle(fontSize = 14.sp))
                        Spacer(Modifier.height(32.dp))
                    }

                    Column(Modifier.clickable(onClick = {
                        val phoneNumber = "+972568711400"
                        val url = "https://wa.me/$phoneNumber?text=${Uri.encode("Hello, I want to chat with you!")}"
                        val intent = Intent(Intent.ACTION_VIEW).apply {
                            data = Uri.parse(url)
                        }

                        if (intent.resolveActivity(context.packageManager) != null) {
                            context.startActivity(intent)
                        }
                    })) {
                        Image(painter = painterResource(R.drawable.whatsapp,), contentDescription = "", modifier = Modifier.size(45.dp))
                        Spacer(Modifier.height(8.dp))
                        TextItem(stringResource(R.string.whatsapp), style = TextStyle(fontSize = 14.sp))
                        Spacer(Modifier.height(32.dp))
                    }



                }

        }
    }
