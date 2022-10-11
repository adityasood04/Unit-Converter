package com.app.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.unitconverter.ui.theme.UnitConverterTheme

class DistanceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    distanceActivity()
                }
            }
        }
    }
}

@Composable
fun textField() {
    androidx.compose.material.Surface(modifier = Modifier.fillMaxSize()) {
        var n1 = remember {
            mutableStateOf("0")

        }
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(R.color.bodybg))) {
            OutlinedTextField(
                value = n1.value,
                onValueChange = { newVal->
                    n1.value = newVal
                },colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = colorResource(R.color.buttonbg)
                )
            )
            Column(
                modifier=Modifier.padding(45.dp,0.dp)
            ) {
                Row(modifier = Modifier.padding(0.dp,20.dp,0.dp,0.dp)) {
                    OutlinedButton(onClick = { /*TODO*/ },shape = RoundedCornerShape(15.dp),
                        border = BorderStroke(2.dp, colorResource(R.color.buttonStroke)),
                        modifier = Modifier
                            .weight(1f)
                            .padding(10.dp)) {
                        Text(text = "Km to m",color = colorResource(id = R.color.black))
                    }
                    OutlinedButton(onClick = { /*TODO*/ },shape = RoundedCornerShape(15.dp),
                        border = BorderStroke(2.dp, colorResource(R.color.buttonStroke)),
                        modifier = Modifier
                            .weight(1f)
                            .padding(10.dp)) {
                        Text(text = "m to km",color = colorResource(id = R.color.black))
                    }
                }
                Row() {
                    OutlinedButton(onClick = { /*TODO*/ },shape = RoundedCornerShape(15.dp),
                        border = BorderStroke(2.dp, colorResource(R.color.buttonStroke)),
                        modifier = Modifier
                            .weight(1f)
                            .padding(10.dp)) {
                        Text(text = "m to cm",color = colorResource(id = R.color.black))
                    }
                    OutlinedButton(onClick = { /*TODO*/ },shape = RoundedCornerShape(15.dp),
                        border = BorderStroke(2.dp, colorResource(R.color.buttonStroke)),
                        modifier = Modifier
                            .weight(1f)
                            .padding(10.dp)) {
                        Text(text = "cm to m",color = colorResource(id = R.color.black))
                    }
                }
            }



        }


    }
}
@Composable
fun distanceActivity(){

    Column(modifier = Modifier
        .fillMaxSize()

    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxWidth()

        ) {
            Column(Modifier.background(colorResource(R.color.upperStrip))) {
                Text(text = "Distance Converter", textAlign = TextAlign.Center, color = colorResource(id = R.color.white),
                    fontFamily = FontFamily.Monospace,
                    fontSize = 20.sp, modifier = Modifier
                        .padding(0.dp, 10.dp)
                        .fillMaxWidth()

                )
            }

        }
        textField()

    }





}


@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    UnitConverterTheme {
        distanceActivity()
    }
}