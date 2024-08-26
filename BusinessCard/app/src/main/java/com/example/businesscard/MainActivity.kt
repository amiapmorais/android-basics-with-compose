package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.common.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BottomCardRow(icon: ImageVector, iconName: String, contactInfo: String, modifier: Modifier) {
    Row(
        modifier = modifier.width(250.dp)
    )
    {
        Icon(
            imageVector = icon,
            contentDescription = "An $iconName icon",
            tint = colorResource(id = R.color.highlight)
        )
        Spacer(Modifier.width(24.dp))
        Text(
            text = contactInfo,
        )
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    ContactInfos(modifier)
    PersonInfo()
}

@Composable
fun PersonInfo(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.perfil)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(top = 200.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = image,
            contentDescription = stringResource(R.string.text_photo),
            modifier = modifier
                .size(200.dp)
                .padding(bottom = 16.dp)
        )
        Text(
            text = stringResource(R.string.text_name),
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Light,
            fontSize = 40.sp,
            modifier = modifier.padding(bottom = 16.dp)
        )
        Text(
            text = stringResource(R.string.text_title),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.highlight)
        )
    }
}

@Composable
fun ContactInfos(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.background))
    )
    {
        BottomCardRow(
            icon = Icons.Default.Call,
            iconName = Icons.Default.Call.name,
            contactInfo = stringResource(R.string.text_phone),
            modifier = Modifier
        )
        BottomCardRow(
            icon = Icons.Default.Share,
            iconName = Icons.Default.Share.name,
            contactInfo = stringResource(R.string.text_social_media),
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
        )
        BottomCardRow(
            icon = Icons.Default.Email,
            iconName = Icons.Default.Email.name,
            contactInfo = stringResource(R.string.text_email_address),
            modifier = Modifier.padding(bottom = 32.dp)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}