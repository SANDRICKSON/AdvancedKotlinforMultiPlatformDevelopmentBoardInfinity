package com.example.advancedkotlinformulti_platformdevelopmentboardinfinity

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "AdvancedKotlinForMultiPlatformDevelopmentBoardInfinity",
    ) {
        App()
    }
}