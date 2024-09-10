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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
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

enum class ArtDisplayed {
    PSYDUCKS, FARFETCHDS, PIKACHUS
}

class Art (
    val image: Painter,
    val imageDescription: String,
    val title: String,
    val artist: String,
    val year: String
)

@Composable
fun ArtSpace(modifier: Modifier = Modifier) {
    var artDisplayed by remember { mutableStateOf(ArtDisplayed.PSYDUCKS) }

    val art = when (artDisplayed) {
        ArtDisplayed.PSYDUCKS -> Art(
            image = painterResource(id = R.drawable._04ddb287758d86296047b8ac3de2477),
            imageDescription = stringResource(id = R.string.psyducks_content_description),
            title = stringResource(id = R.string.psyducks_artwork_title),
            artist = stringResource(id = R.string.psyducks_artwork_artist),
            year = stringResource(id = R.string.psyducks_artwork_year)
        )
        ArtDisplayed.FARFETCHDS -> Art(
            image = painterResource(id = R.drawable._579667fb1cacc2f8364530865910e57),
            imageDescription = stringResource(id = R.string.farfetchds_content_description),
            title = stringResource(id = R.string.farfetchds_title),
            artist = stringResource(id = R.string.farfetchds_artist),
            year = stringResource(id = R.string.farfetchds_year)
        )
        else -> Art(
            image = painterResource(id = R.drawable._da00b17bf13dac259da13d0e7fa8135),
            imageDescription = stringResource(id = R.string.pikachus_content_description),
            title = stringResource(id = R.string.pikachus_title),
            artist = stringResource(id = R.string.pikachus_artist),
            year = stringResource(id = R.string.pikachus_year))
    }
    Column (
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ArtWall(art)
        Spacer(modifier = modifier.height(50.dp))
    }
    Column (
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier.fillMaxSize()
    ) {
        Row {
            Button (
                onClick = {
                    artDisplayed = when (artDisplayed) {
                        ArtDisplayed.PSYDUCKS -> ArtDisplayed.PIKACHUS
                        ArtDisplayed.PIKACHUS -> ArtDisplayed.FARFETCHDS
                        else -> ArtDisplayed.PSYDUCKS
                    }
                },
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
                onClick = {
                    artDisplayed = when (artDisplayed) {
                        ArtDisplayed.PSYDUCKS -> ArtDisplayed.FARFETCHDS
                        ArtDisplayed.FARFETCHDS -> ArtDisplayed.PIKACHUS
                        else -> ArtDisplayed.PSYDUCKS
                    }
                },
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
fun ArtWall(art: Art) {
    Surface(
        shadowElevation = 8.dp,
        modifier = Modifier
            .height(500.dp)
            .fillMaxWidth()
            .padding(
                horizontal = 32.dp, vertical = 60.dp
            )
    ){
        Image(
            painter = art.image,
            contentDescription = art.imageDescription,
            modifier = Modifier
                .padding(32.dp)
        )
    }
    // Art Descriptor
    Surface(
        color = Color.LightGray,
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp)
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Text(
                fontWeight = FontWeight.Light,
                fontSize = 24.sp,
                text = art.title,
                textAlign = TextAlign.Start,
            )
            Row {
                Text(
                    text = art.artist,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(text = "(${art.year})")
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}