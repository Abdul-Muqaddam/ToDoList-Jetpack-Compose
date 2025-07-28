package com.example.todotutorial

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todotutorial.core.locale.LocaleManager
import com.example.todotutorial.data.AppPreference

import com.example.todotutorial.practice.Practice
import com.example.todotutorial.presentation.LanguageScreen.LanguageScreen
import com.example.todotutorial.presentation.add_todo_screen.AddTodoScreen
import com.example.todotutorial.presentation.dashboard_screen.DashboardScreen
import com.example.todotutorial.presentation.setting_screen.SettingScreen
import com.example.todotutorial.presentation.splash_screen.SplashScreen
import com.example.todotutorial.presentation.task_details_screen.TaskDetailsScreen
import com.example.todotutorial.ui.theme.TODOTutorialTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun attachBaseContext(newBase: Context) {
        val languageCode = AppPreference.getLanguageCode()
        val context = LocaleManager.setLocale(newBase, languageCode)
        super.attachBaseContext(context)
    }

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
                        SplashScreen(navigateToDashboardScreen = {
                            navController.navigate(Routes.DashboardScreenRoute) {
                                popUpTo(Routes.SplashScreenRoute) {
                                    inclusive = true
                                }
                            }
                        })
                    }
//                    composable<Routes.SigInScreenRoute> {
//                        Signin(navigateToLogInScreen = {
//                            navController.navigate(Routes.LogInScreenRoute)
//                        })
//                    }
//                    composable<Routes.LogInScreenRoute> {
//                        LogInScreen(navigateToDashboardScreen = {
//                            navController.navigate(Routes.DashboardScreenRoute) {
//                                popUpTo(Routes.LogInScreenRoute) {
//                                    inclusive = true
//                                }
//                            }
//                        }, navigateToSigninScreen = {
//                            navController.navigate(Routes.SigInScreenRoute)
//                        })
//                    }
                    composable<Routes.DashboardScreenRoute> {
                        DashboardScreen(navigateToAddToDoScreen = {
                            navController.navigate(Routes.AddTODOScreenRoute)
                        }, onNavigateToTaskDetailsScreen = {
                            navController.navigate(Routes.TaskDetailsScreen)
                        }, NavigateToSettingScreen = {
                            navController.navigate(Routes.SettingScreenRoute)
                        })
                    }
                    composable<Routes.SettingScreenRoute> {
                        SettingScreen(navigateToLanguageScreen = {
                            navController.navigate(Routes.LanguageScreenRoute)
                        })
                    }
                    composable<Routes.TaskDetailsScreen> {
                        TaskDetailsScreen(navigateBack = {
                            navController.navigate(Routes.DashboardScreenRoute)
                        })
                    }
                    composable<Routes.AddTODOScreenRoute> {
                        AddTodoScreen(navigateBack = {
                            navController.popBackStack()
                        })
                    }
                    composable<Routes.Practice> {
                        Practice()
                    }

                    composable<Routes.LanguageScreenRoute> {
                        LanguageScreen(
                            navigateBckToSettingScreen = {
                                navController.navigate(Routes.SettingScreenRoute)
                            },
                            onLanguageApplyClicked = {
                                val intent = Intent(this@MainActivity, MainActivity::class.java)
                                intent.flags =
                                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                startActivity(intent)
                                finish()
                            }
                        )
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
    object SettingScreenRoute

    @Serializable
    object LanguageScreenRoute

    @Serializable
    object TaskDetailsScreen

    @Serializable
    object Practice
}
