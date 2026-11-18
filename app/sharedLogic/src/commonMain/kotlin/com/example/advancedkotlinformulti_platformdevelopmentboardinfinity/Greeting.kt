package com.example.advancedkotlinformulti_platformdevelopmentboardinfinity

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return sayHello(platform.name)
    }
}