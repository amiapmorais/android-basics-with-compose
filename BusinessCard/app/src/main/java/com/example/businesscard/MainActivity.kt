package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ContactInfos(
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
            tint = colorResource(id = R.color.teal_700)
        )
        Spacer(Modifier.width(24.dp))
        Text(
            text = contactInfo,
        )
    }
}

@Composable
fun ContactInfos(modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    )
    {
        BottomCardRow(
            icon = Icons.Default.Call,
            iconName = Icons.Default.Call.name,
            contactInfo = stringResource(R.string.text_phone),
            modifier = modifier
        )
        BottomCardRow(
            icon = Icons.Default.Share,
            iconName = Icons.Default.Share.name,
            contactInfo = stringResource(R.string.text_social_media),
            modifier = modifier.padding(top = 16.dp, bottom = 16.dp)
        )
        BottomCardRow(
            icon = Icons.Default.Email,
            iconName = Icons.Default.Email.name,
            contactInfo = stringResource(R.string.text_email_address),
            modifier = modifier.padding(bottom = 24.dp)
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
        ContactInfos()
    }
}