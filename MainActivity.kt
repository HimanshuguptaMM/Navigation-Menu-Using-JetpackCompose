package com.example.clone

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.clone.ui.theme.CloneTheme
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CloneTheme() {
DefaultAppBar (onScreenClicked = {})
                // A surface container using the 'background' color from the theme
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        AppBar(
                            onNavigationIconClick = {
                                scope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            }
                        )

                    },
                    drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(
                            items = listOf(
                                MenuItem(
                                    id = "home",
                                    title = "Home",
                                    contentDescription = "Go to home",
                                    icon = Icons.Default.Home
                                ),
                                MenuItem(
                                    id = "cart",
                                    title = "Cart",
                                    contentDescription = "Go to Cart",
                                    icon = Icons.Default.ShoppingCart
                                ),
                                MenuItem(
                                    id = "settings",
                                    title = "Settings",
                                    contentDescription = "Go to Settings",
                                    icon = Icons.Default.Settings
                                ),

                                MenuItem(
                                    id = "help",
                                    title = "Help",
                                    contentDescription = "Go to help",
                                    icon = Icons.Default.Info

                                ),
                                MenuItem(
                                    id = "logout",
                                    title = "Logout",
                                    contentDescription = "Logout User",
                                    icon = Icons.Default.ArrowBack

                                ),

                                ),
                            onItemClick = {


                                println("clickon ${it.title}")
                            }
                        )
                    }
                ) {


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CloneTheme {
        Greeting("Android")
    }
}

@Composable
fun DefaultAppBar(onScreenClicked: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = "Home")
        },
        actions = {
            IconButton(onClick = { onScreenClicked() }
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "search",
                tint = androidx.compose.ui.graphics.Color.White
                )
            }


        }
    )
}