package com.app.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
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
fun textFields2() {

    val mContext = LocalContext.current
    androidx.compose.material.Surface(modifier = Modifier.fillMaxSize()) {
        var n1 = remember {
            mutableStateOf("")

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
                ), shape = RoundedCornerShape(20.dp)
                , placeholder = {
                    Text(text = "Enter the value here")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            var result by remember {
                mutableStateOf("")
            }
            Column(
                modifier=Modifier.padding(45.dp,0.dp)
            ) {
                Row(modifier = Modifier.padding(0.dp,20.dp,0.dp,0.dp)) {
                    OutlinedButton(onClick = {if(!n1.value.isEmpty()){
                        var mResult = Integer.parseInt(n1.value)*60
                        result = "${n1.value} hours = ${mResult.toString()} minutes"
                    }
                    else{
                        Toast.makeText(mContext,"Enter some value first",Toast.LENGTH_SHORT).show()
                    }
                                             }
                        ,shape = RoundedCornerShape(15.dp),
                        border = BorderStroke(2.dp, colorResource(R.color.buttonStroke)),
                        modifier = Modifier
                            .weight(1f)
                            .padding(10.dp)) {
                        Text(text = "Hrs to mins",color = colorResource(id = R.color.black))
                    }
                    OutlinedButton(onClick = { if(!n1.value.isEmpty()){
                        var mResult = Integer.parseInt(n1.value)*0.0167
                        result = "${n1.value} minutes = ${mResult.toString()} hours"
                    }
                        else{
                            Toast.makeText(mContext,"Enter some value first",Toast.LENGTH_SHORT).show()
                    }
                                             },
                        shape = RoundedCornerShape(15.dp),
                        border = BorderStroke(2.dp, colorResource(R.color.buttonStroke)),
                        modifier = Modifier
                            .weight(1f)
                            .padding(10.dp)) {
                        Text(text = "mins to Hrs",color = colorResource(id = R.color.black))
                    }
                }
                Row() {
                    OutlinedButton(onClick = {
                        if(!n1.value.isEmpty()){
                        var mResult = Integer.parseInt(n1.value)*60
                        result = "${n1.value} minutes = ${mResult.toString()} seconds"
                                             }
                        else{
                        Toast.makeText(mContext,"Enter some value first",Toast.LENGTH_SHORT).show()
                    }}
                        ,shape = RoundedCornerShape(15.dp),
                        border = BorderStroke(2.dp, colorResource(R.color.buttonStroke)),
                        modifier = Modifier
                            .weight(1f)
                            .padding(10.dp)) {
                        Text(text = "mins to secs",color = colorResource(id = R.color.black))
                    }
                    OutlinedButton(onClick = {if(!n1.value.isEmpty()){
                        var mResult = Integer.parseInt(n1.value)*0.0167
                        result = "${n1.value} seconds = ${mResult.toString()} minutes"
                            }
                        else{
                        Toast.makeText(mContext,"Enter some value first",Toast.LENGTH_SHORT).show()
                        }
                                             }
                        ,shape = RoundedCornerShape(15.dp),
                        border = BorderStroke(2.dp, colorResource(R.color.buttonStroke)),
                        modifier = Modifier
                            .weight(1f)
                            .padding(10.dp)) {
                        Text(text = "sec to mins",color = colorResource(id = R.color.black))
                    }
                }
                Box(modifier = Modifier.padding(12.dp)){
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .background(colorResource(R.color.buttonbg))
                        .padding(35.dp),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = result, color = colorResource(R.color.black))
                    }
                }

            }





        }




    }
}
@Composable
fun timeActivity(){

    Column(modifier = Modifier
        .fillMaxSize()

    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxWidth()

        ) {
            Column(Modifier.background(colorResource(R.color.upperStrip))) {
                Text(text = "Time Converter", textAlign = TextAlign.Center, color = colorResource(id = R.color.white),
                    fontFamily = FontFamily.Monospace,
                    fontSize = 20.sp, modifier = Modifier
                        .padding(0.dp, 10.dp)
                        .fillMaxWidth()

                )
            }

        }
        textFields2()

    }





}@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    UnitConverterTheme {
        timeActivity()
    }
}