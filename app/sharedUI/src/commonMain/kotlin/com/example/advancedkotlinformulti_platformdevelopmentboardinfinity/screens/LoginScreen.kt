package com.example.advancedkotlinformulti_platformdevelopmentboardinfinity.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.safeContentPadding

import androidx.compose.material3.MaterialTheme

import androidx.compose.runtime.Composable


import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import com.example.advancedkotlinformulti_platformdevelopmentboardinfinity.components.LoginButton


@Composable
fun LoginScreen() {
    MaterialTheme {

        Column(
            modifier = Modifier
                .background(Color.Gray)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LoginButton() {}
        }
    }
}