package com.example.chatapp.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chatapp.Screens.ChatScreen
import com.example.chatapp.Screens.HomeScreen
import com.example.chatapp.Screens.StartScreen

@Composable
fun MainNavigation() {

    val navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = Start){
        composable(Start){
            StartScreen(navHostController)
        }
        composable(Home){
            HomeScreen(navHostController)
        }
        composable(Chat){
            ChatScreen(navHostController)
        }
    }
}

const val Home = "Home_Screen"
const val Start = "Start_Screen"
const val Chat = "Chat_Screen"