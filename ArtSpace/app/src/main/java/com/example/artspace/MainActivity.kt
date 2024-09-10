package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtSpace(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArtSpace(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxSize()
    )
    {
        val image = painterResource(id = R.drawable._04ddb287758d86296047b8ac3de2477)
//        val image = painterResource(id = R.drawable._579667fb1cacc2f8364530865910e57)

        Surface (
            shadowElevation = 8.dp,
            modifier = Modifier
                .weight(0.5f)
                .fillMaxWidth()
                .padding(
                    horizontal = 32.dp, vertical = 32.dp
                )
        ){
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .padding(32.dp)
            )
        }

        Surface (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .weight(0.5f)
        ){
            Text(text = "Nome da obra")
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}