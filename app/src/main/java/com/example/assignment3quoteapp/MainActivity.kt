package com.example.assignment3quoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import com.example.assignment3quoteapp.ui.theme.Assignment3QuoteAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment3QuoteAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuoteApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun QuoteApp(modifier: Modifier = Modifier) {

    val quotes = listOf(
        "If you don’t take risks, you can’t create a future. – Monkey D. Luffy",
        "I don’t wanna conquer anything. I just think the guy with the most freedom in this whole ocean... is the Pirate King! – Monkey D. Luffy",
        "When do you think people die? When they are shot by a bullet? No, it's when they are forgotten. – Dr. Hiluluk",
        "Protecting what we cherish most as men is the reason why we formed this pirate crew! – Roronoa Zoro",
        "You need to accept the fact that you're not the best and have all the will to strive to be better than anyone you face. – Roronoa Zoro",
        "Stop counting only those things you have lost! What is gone, is gone! So ask yourself this: What is there... that still remains to you?! – Jinbei",
        "Living is important! It’s because one lives, one can enjoy things! – Charlotte Katakuri",
        "No matter how hard or how impossible it is, never lose sight of your goal. – Monkey D. Luffy",
        "Power isn’t determined by your size, but the size of your heart and dreams! – Monkey D. Luffy",
        "Don’t start a fight if you can’t end it. – Sanji",
        "One may stray from the path of a man, one may stray from the path of a woman, but there is no straying from the path of a human! – Franky",
        "If you lose credibility by just admitting fault, then you didn’t have any in the first place. – Fujitora"
    )

    var currentQuoteIndex by remember { mutableStateOf(Random.nextInt(quotes.size)) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = quotes[currentQuoteIndex],
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(onClick = {
            currentQuoteIndex = Random.nextInt(quotes.size)
        }) {
            Text(text = "New Quote")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuoteAppPreview() {
    Assignment3QuoteAppTheme {
        QuoteApp()
    }
}
