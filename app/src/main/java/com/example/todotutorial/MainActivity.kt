package com.example.todotutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import appModule

import com.example.todotutorial.practice.Practice
import com.example.todotutorial.practice.PracticeViewModel
import com.example.todotutorial.presentation.add_todo_screen.AddTodoScreen
import com.example.todotutorial.presentation.dashboard_screen.DashboardScreen
import com.example.todotutorial.presentation.log_in_screen.LogInScreen
import com.example.todotutorial.presentation.sign_in_screen.Signin
import com.example.todotutorial.presentation.splash_screen.SplashScreen
import com.example.todotutorial.presentation.task_details_screen.TaskDetailsScreen
import com.example.todotutorial.ui.theme.TODOTutorialTheme
import kotlinx.serialization.Serializable
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            TODOTutorialTheme {
                var navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Routes.SplashScreenRoute
//                        Routes.SplashScreenRoute
                ) {
                    composable<Routes.SplashScreenRoute> {
                        SplashScreen(navigateToSiginScreen = {
                            navController.navigate(Routes.SigInScreenRoute)
                        })
                    }
                    composable<Routes.SigInScreenRoute> {
                        Signin(navigateToLogInScreen = {
                            navController.navigate(Routes.LogInScreenRoute)
                        })
                    }
                    composable<Routes.LogInScreenRoute> {
                        LogInScreen(navigateToDashboardScreen = {
                            navController.navigate(Routes.DashboardScreenRoute)
                        })
                    }
                    composable<Routes.DashboardScreenRoute> {
                        DashboardScreen(navigateToAddToDoScreen = {
                            navController.navigate(Routes.AddTODOScreenRoute)
                        }, onNavigateToTaskDetailsScreen = {
                            navController.navigate(Routes.TaskDetailsScreen)
                        })
                    }
                    composable<Routes.TaskDetailsScreen> {
                        TaskDetailsScreen(navigateBack = {})
                    }
                    composable<Routes.AddTODOScreenRoute> {
                        AddTodoScreen(navigateBack = {
                            navController.popBackStack()
                        })
                    }
                    composable<Routes.Practice> {
                        Practice()
                    }
                }



            }
        }
    }
}

sealed class Routes() {

    @Serializable
    object SplashScreenRoute

    @Serializable
    object SigInScreenRoute

    @Serializable
    object LogInScreenRoute

    @Serializable
    object DashboardScreenRoute

    @Serializable
    object AddTODOScreenRoute

    @Serializable
    object TaskDetailsScreen
    @Serializable
    object Practice
}
