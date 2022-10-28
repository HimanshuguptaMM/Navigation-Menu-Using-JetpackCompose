package com.example.clone

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable


@Composable
fun AppBar(
    onNavigationIconClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = "eBay")
        },
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
            }
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "toggle drawer"
            )


        }
    )
}