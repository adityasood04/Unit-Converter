package com.app.unitconverter

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.app.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    unitConverter()

                }
                val ctx = applicationContext
            }
        }
    }
}

@Composable
fun unitConverter() {
    val mContext = LocalContext.current
    Surface(modifier=Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Unit Converter", fontSize = 38.sp, modifier = Modifier.padding(20.dp))
        }
        Column( horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            OutlinedButton(onClick = {
                mContext.startActivity(Intent(mContext, CurrencyActivity::class.java))
            },modifier = Modifier.fillMaxWidth().padding(10.dp)) {
                Text(text = "Currency Converter", fontSize = 24.sp)
            }
            OutlinedButton(onClick = { mContext.startActivity(Intent(mContext, TimeActivity::class.java)) },modifier = Modifier.fillMaxWidth().padding(10.dp)) {
                Text(text = "Time Unit Converter", fontSize = 24.sp)
            }
            OutlinedButton(onClick = { mContext.startActivity(Intent(mContext, DistanceActivity::class.java)) },modifier = Modifier.fillMaxWidth().padding(10.dp)) {
                Text(text = "Distance Unit Converter", fontSize = 24.sp)
            }
        }

    }

    
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UnitConverterTheme {
        unitConverter()
    }
}