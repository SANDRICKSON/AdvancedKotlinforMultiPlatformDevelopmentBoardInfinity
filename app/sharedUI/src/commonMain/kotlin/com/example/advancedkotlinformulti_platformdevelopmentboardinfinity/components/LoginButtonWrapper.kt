package com.example.advancedkotlinformulti_platformdevelopmentboardinfinity.components

import androidx.compose.runtime.Composable

@Composable
expect fun LoginButtonWrapper(
    onLogin: (idToken: String) -> Unit
)

