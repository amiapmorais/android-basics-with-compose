package com.example.affirmations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.affirmations.ui.theme.AffirmationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AffirmationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AffirmationsApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun AffirmationsApp(modifier: Modifier = Modifier) {

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun AffirmationsAppPreview() {
    AffirmationsTheme {
        AffirmationsApp()
    }
}