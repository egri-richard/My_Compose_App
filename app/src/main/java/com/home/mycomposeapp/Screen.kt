package com.home.mycomposeapp

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object SettingsScreen: Screen("settings_screen")
    object AccountScreen: Screen("account_screen")
}
