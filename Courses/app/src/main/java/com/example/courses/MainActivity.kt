package com.example.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.data.DataSource
import com.example.courses.model.Topic
import com.example.courses.ui.theme.CoursesTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TopicGrid(
                        topics = DataSource.topics,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TopicCard(topic: Topic) {
    Card(
//        modifier = Modifier,
//            .fillMaxWidth()
//            .padding(16.dp),
//        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            // Image section
            Image(
                painter = painterResource(id = topic.imageResId),
                contentDescription = "Topic Image",
                modifier = Modifier.size(68.dp),
                contentScale = ContentScale.Crop
            )

            // Text section
            Column(
                modifier = Modifier
                    .padding(top= 16.dp,
                        start = 16.dp,
                        end = 16.dp)
            ) {
                Text(
                    text = stringResource(id = topic.nameResId),
                    style = MaterialTheme.typography.bodyMedium
//                        .copy(
//                            fontSize = 20.sp,
//                            fontWeight = FontWeight.Bold
//                        )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Icon
                    Icon(
                        imageVector = Icons.Default.Face,
                        contentDescription = "Icon",
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    // Label
                    Text(
                        text = topic.numberOfStudents.toString(),
                        style = MaterialTheme.typography.labelMedium
//                            .copy(
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.SemiBold
//                        )
                    )
                }
            }
        }
    }
}

@Composable
fun TopicGrid(topics: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
//        columns = GridCells.Adaptive(minSize = 150.dp), // Adaptive grid
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(topics) { topic ->
            TopicCard(topic = topic)
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun CardPreview() {
    CoursesTheme {
        TopicGrid(topics = DataSource.topics)
    }
}