package com.home.mycomposeapp

import DrawerBody
import DrawerHeader
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.home.mycomposeapp.ui.theme.MyComposeAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
                                Toast.makeText(
                                    applicationContext,
                                    "Clicked on ${it.title}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        )
                    }
                ) {

                }
            }
        }
    }
}