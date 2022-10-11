package com.app.unitconverter

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()


                ) {
                    unitConverter()

                }
            }
        }
    }
}

@Composable
fun unitConverter() {
    val mContext = LocalContext.current
    Surface(
        modifier= Modifier
        .fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.background(
            colorResource(R.color.bodybg))) {
            Column(Modifier.background(colorResource(R.color.upperStrip))) {
                Text(text = "Unit Converter", textAlign = TextAlign.Center, color = colorResource(id = R.color.white),
                    fontFamily = FontFamily.Monospace,
                    fontSize = 20.sp, modifier = Modifier
                        .padding(0.dp, 10.dp)
                        .fillMaxWidth()
                        
                )
            }

        }
        Column( horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Button(

                onClick = {
                    mContext.startActivity(Intent(mContext, CurrencyActivity::class.java))
                },shape = RoundedCornerShape(30.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                colors = ButtonDefaults
                    .buttonColors(backgroundColor = colorResource(R.color.buttonbg))
            ) {
                Image(painter = painterResource(R.drawable.currency),
                    contentDescription = null, modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                        .weight(1f))
                Text(text = "Currency Converter", fontSize = 24.sp,
                    modifier = Modifier
                        .weight(4f)
                        .padding(0.dp, 18.dp))
            }
            Button(onClick = {
                mContext.startActivity(Intent(mContext, TimeActivity::class.java)) },modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.buttonbg))
            ) {
                Image(painter = painterResource(R.drawable.time),
                    contentDescription = null, modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                        .weight(1f))
                Text(text = "Time Converter", fontSize = 24.sp,
                    modifier = Modifier
                        .padding(0.dp, 18.dp)
                        .weight(4f))
            }
            Button(onClick = { mContext.startActivity(Intent(mContext, DistanceActivity::class.java)) },modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
                colors = ButtonDefaults
                    .buttonColors(backgroundColor = colorResource(R.color.buttonbg))
                ,shape = RoundedCornerShape(30.dp)
            ) {
                Image(painter = painterResource(R.drawable.distance),
                    contentDescription = null, modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                        .weight(1f))
                Text(text = "Distance Converter", fontSize = 24.sp,
                    modifier = Modifier
                        .weight(4f)
                        .padding(0.dp, 18.dp))
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