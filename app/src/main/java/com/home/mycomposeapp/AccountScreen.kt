package com.home.mycomposeapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.home.mycomposeapp.ui.theme.MyComposeAppTheme

@Composable
fun AccountScreen() {
    MyComposeAppTheme() {
        Scaffold() {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center             
            ) {
                Text(text = "Account screen")
            }
        }
    }
}