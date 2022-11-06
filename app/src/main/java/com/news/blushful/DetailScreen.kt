package com.news.blushful

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.news.blushful.ui.theme.UNNTheme

@Composable
fun DetailScreen(details: String, time: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Details",
            Modifier
                .fillMaxWidth()
                .padding(5.dp),
            Color.Blue,
            fontSize = TextUnit.Unspecified,
            textAlign = TextAlign.Center
        )
        Text(text = time, Modifier.padding(5.dp))
        Text(text = details, Modifier.padding(5.dp))
    }
}
