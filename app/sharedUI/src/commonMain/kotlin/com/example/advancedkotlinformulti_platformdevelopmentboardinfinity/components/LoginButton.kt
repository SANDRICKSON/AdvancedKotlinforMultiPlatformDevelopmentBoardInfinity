package com.example.advancedkotlinformulti_platformdevelopmentboardinfinity.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun LoginButton(
    onClick:()-> Unit
){
    Button(
        onClick=onClick,
        modifier = Modifier.height(48.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White
        )
    ){
        Text(
            text = "Login",
            fontWeight = FontWeight.Bold
        )
    }
}