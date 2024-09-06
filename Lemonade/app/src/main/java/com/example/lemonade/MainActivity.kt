package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {
                                Text(
                                    text = stringResource(id = R.string.app_name),
                                    fontWeight = FontWeight.Bold
                                )
                            },
                            colors = TopAppBarDefaults.largeTopAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer
                            )
                        )
                    },
                    modifier = Modifier.fillMaxSize()
                )
                { innerPadding ->
                    Lemonade(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun Lemonade(modifier: Modifier = Modifier) {
    var step by remember { mutableIntStateOf(1) }
    var secondStepTapCount by remember { mutableIntStateOf(0) }

    when(step){
        1 -> LemonImageAndText(
                drawableResourceId = R.drawable.lemon_tree,
                contentDescriptionResourceId = R.string.lemon_tree_content_description,
                labelResourceId = R.string.first_step_text,
                modifier = modifier
            ) {
                secondStepTapCount = (2..4).random()
                step = 2
            }

        2 -> LemonImageAndText(
                drawableResourceId = R.drawable.lemon_squeeze,
                contentDescriptionResourceId = R.string.lemon_content_description,
                labelResourceId = R.string.second_step_text,
                modifier = modifier
            ) {
                secondStepTapCount--
                if (secondStepTapCount == 0) step = 3
            }

        3 -> LemonImageAndText(
                drawableResourceId = R.drawable.lemon_drink,
                contentDescriptionResourceId = R.string.lemonade_content_description,
                labelResourceId = R.string.third_step_text,
                modifier = modifier
            ) {
                step = 4
            }

        4 -> LemonImageAndText(
            drawableResourceId = R.drawable.lemon_restart,
            contentDescriptionResourceId = R.string.empty_glass_content_description,
            labelResourceId = R.string.fourth_step_text,
            modifier = modifier
        ) {
            step = 1
        }
    }
}

@Composable
fun LemonImageAndText(
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    labelResourceId: Int,
    modifier: Modifier,
    onClickImage: () -> Unit,
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
    {
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.tertiaryContainer
            ),
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.button_corner_radius)),
            onClick = onClickImage
        ) {
            Image(
                painter = painterResource(id = drawableResourceId),
                contentDescription = stringResource(id = contentDescriptionResourceId)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(id = labelResourceId), fontSize = 18.sp)
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun LemonadePreview() {
    LemonadeTheme {
        Lemonade()
    }
}