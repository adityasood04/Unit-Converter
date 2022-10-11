package com.app.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.unitconverter.ui.theme.UnitConverterTheme

class TimeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    timeActivity()
                }
            }
        }
    }
}

@Composable
fun timeActivity() {
    androidx.compose.material.Surface(modifier = Modifier.fillMaxSize()) {
        var n1 = remember {
            mutableStateOf("0")

        }
        var n2 = remember {
            mutableStateOf("0")

        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Time Converter", fontSize = 28.sp, modifier = Modifier.padding(20.dp))
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center ) {
            OutlinedTextField(
                value = n1.value,
                onValueChange = { newVal->
                    n1.value = newVal
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "=", fontSize = 30.sp)
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = n2.value,
                onValueChange = { newVal->
                    n2.value = newVal
                }
            )

        }


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    UnitConverterTheme {
        timeActivity()
    }
}