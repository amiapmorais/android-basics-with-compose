package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            .verticalScroll(rememberScrollState())
    )
    {
        ArtWall(
            imageResourceId = R.drawable._04ddb287758d86296047b8ac3de2477,
            contentDescriptionResourceId = R.string.psyducks_content_description
        )
        ArtDescriptor(
            titleResourceId = R.string.psyducks_artwork_title,
            artistResourceId = R.string.psyducks_artwork_artist,
            yearResourceId = R.string.psyducks_artwork_year
        )
        Spacer(modifier = modifier.height(50.dp))
    }
    Column (
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier.fillMaxSize()
    )
    {
        Row {
            Button (
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .weight(0.5f)
                    .padding(
                        horizontal = 16.dp,
                        vertical = 16.dp
                    )
            ) {
                Text(text = stringResource(R.string.previous_button))
            }
            Button (
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .weight(0.5f)
                    .padding(
                        horizontal = 16.dp,
                        vertical = 16.dp
                    )
            ) {
                Text(text = stringResource(R.string.next_button))
            }
        }
    }
}

@Composable
fun ArtWall (
    imageResourceId: Int,
    contentDescriptionResourceId: Int,
) {
    Surface (
        shadowElevation = 8.dp,
        modifier = Modifier
            .height(500.dp)
            .fillMaxWidth()
            .padding(
                horizontal = 32.dp, vertical = 60.dp
            )
    ){
        Image(
            painter = painterResource(imageResourceId),
            contentDescription = stringResource(contentDescriptionResourceId),
            modifier = Modifier
                .padding(32.dp)
        )
    }
}

@Composable
fun ArtDescriptor (
    titleResourceId: Int,
    artistResourceId: Int,
    yearResourceId: Int
) {
    Surface (
        color = Color.LightGray,
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp)
    ) {
        Column(
            modifier = Modifier.padding(24.dp)
        )
        {
            Text(
                fontWeight = FontWeight.Light,
                fontSize = 24.sp,
                text = stringResource(titleResourceId),
                textAlign = TextAlign.Start,
            )
            Row {
                Text(
                    text = stringResource(artistResourceId),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = "(${stringResource(yearResourceId)})"
                )
            }
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