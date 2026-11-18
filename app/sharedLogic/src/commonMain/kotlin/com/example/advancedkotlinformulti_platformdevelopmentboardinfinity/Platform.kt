package com.example.advancedkotlinformulti_platformdevelopmentboardinfinity

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform