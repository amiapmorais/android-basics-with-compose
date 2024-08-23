package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Article(
                        title = stringResource(R.string.title_text),
                        introduction = stringResource(R.string.introduction_text),
                        article = stringResource(R.string.article_text),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Article(title: String,
            introduction: String,
            article: String,
            modifier: Modifier = Modifier
) {
    Column (modifier = modifier){
        ArticleHead()
        ArticleBody(title, introduction, article)
    }
}

@Composable
fun ArticleHead() {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun ArticleBody(title: String, introduction: String, article: String) {
    Column {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = introduction,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = article,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
    )
@Composable
fun ArticlePreview() {
    ComposeArticleTheme {
        Article(
            title = stringResource(R.string.title_text),
            introduction = stringResource(R.string.introduction_text),
            article = stringResource(R.string.article_text)
        )
    }
}