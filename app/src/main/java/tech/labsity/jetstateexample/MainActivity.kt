package tech.labsity.jetstateexample

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech.labsity.jetstateexample.ui.theme.JetStateExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetStateExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Counter(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(16.dp) // Add padding if needed
                    )
                }
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun Counter(modifier: Modifier = Modifier) {
    var count = remember {
        mutableStateOf(0)
    }
    Column {
        Text("The Counter: ${count.value}")
        Button (onClick = {
            count.value++
            Log.v("TABY", "Counter value: ${count.value}")
        }) {
            Text(text = "Increase Counter")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetStateExampleTheme {
        Counter(
            modifier = Modifier
                .padding(16.dp)
        )
    }
}