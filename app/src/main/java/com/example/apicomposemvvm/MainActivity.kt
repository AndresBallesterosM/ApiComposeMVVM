package com.example.apicomposemvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.apicomposemvvm.ui.screens.MainScreen
import com.example.apicomposemvvm.ui.theme.ApiComposeMVVMTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            ApiComposeMVVMTheme {

                MainScreen()

            }
        }
    }
}