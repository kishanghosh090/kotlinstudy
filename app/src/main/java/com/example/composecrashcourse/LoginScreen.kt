package com.example.composecrashcourse

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreen(){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(bottomEnd = 30.dp, bottomStart = 30.dp))
                .height(200.dp)
                .fillMaxWidth()
                .background(color = Color.Black)

        ) {
            Text("Skip",
                color = Color.White,
                modifier = Modifier
                    .padding(10.dp)
                    ,
                )
        }
    }
}