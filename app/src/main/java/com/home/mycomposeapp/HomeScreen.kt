package com.home.mycomposeapp

import DrawerBody
import DrawerHeader
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.home.mycomposeapp.ui.theme.MyComposeAppTheme
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavController) {
    MyComposeAppTheme {
        val scaffoldState = rememberScaffoldState()
        val drawerScope = rememberCoroutineScope()
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                AppBar(
                    onNavigationClick = {
                        drawerScope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }
                )
            },
            drawerContent = {
                DrawerHeader()
                DrawerBody(
                    items = listOf(
                        MenuItem(
                            id = "home",
                            title = "Home",
                            contentDescription = "Home option",
                            icon = Icons.Default.Home
                        ),
                        MenuItem(
                            id = "settings",
                            title = "Settings",
                            contentDescription = "Settings option",
                            icon = Icons.Default.Settings
                        ),
                        MenuItem(
                            id = "account",
                            title = "Account",
                            contentDescription = "Account option",
                            icon = Icons.Default.AccountCircle
                        )
                    ),
                    onItemClick = {
                        val dest = "${it.id}_screen"
                        val currentRoute = navController.currentBackStackEntry?.destination?.route

                        if (dest != currentRoute) {
                            navController.navigate(dest)
                        }

                        /*Toast.makeText(
                            navController.context,
                            "Clicked on ${it.title}",
                            Toast.LENGTH_SHORT
                        ).show()*/
                    }
                )
            }
        ) {
            Column(
                horizontalAlignment = CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "Home Screen")
            }
        }
    }
}