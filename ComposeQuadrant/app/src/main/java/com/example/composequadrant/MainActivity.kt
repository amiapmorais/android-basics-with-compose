package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComposeQuadrant(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Quadrant(name: String, description: String, color: Color = Color.White, modifier: Modifier) {
    Surface (
        color = color,
        modifier = modifier
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(16.dp)
        ) {
            Text(
                text = name,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = description,
                textAlign = TextAlign.Justify,
            )
        }
    }
}

@Composable
fun ComposeQuadrant(modifier: Modifier = Modifier) {
    Column (
        modifier= modifier
    ){
        Row(
            modifier = Modifier.weight(.5F)
        ) {
            Quadrant(
                name = stringResource(R.string.text_composable_text),
                description = stringResource(R.string.text_description_text),
                color = colorResource(id = R.color.pink),
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(.5F)
            )
            Quadrant(
                name = stringResource(R.string.image_composable_text),
                description = stringResource(R.string.image_description_text),
                color = colorResource(id = R.color.purple_100),
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(.5F)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(.5F)
        ) {
            Quadrant(
                name = stringResource(R.string.row_composable_text),
                description = stringResource(R.string.row_description_text),
                color = colorResource(id = R.color.purple_150),
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(.5F)
            )
            Quadrant(
                name = stringResource(R.string.column_composable_text),
                description = stringResource(R.string.column_description_text),
                color = colorResource(id = R.color.pink_50),
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(.5F)
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ComposeQuadrantPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrant()
    }
}