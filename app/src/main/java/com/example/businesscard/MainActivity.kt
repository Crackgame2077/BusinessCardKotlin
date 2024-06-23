package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {

            }
        }
    }
}

@Composable
fun Card(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Info(
                name = stringResource(R.string.name),
                title = stringResource(R.string.title)
            )
        }

        Box(
            contentAlignment = Alignment.BottomCenter
        ) {
            Contact(
                number = stringResource(R.string.phonenumber),
                email = stringResource(R.string.email),
                linkedin = stringResource(R.string.Linkedin),

            )
        }
    }
}

@Composable
fun Info(name: String, title: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.z5313457364911_177a03b80aaffc1b8167b04003882307)
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.size(width = 400.dp, height = 200.dp)

        )
        Text(
            text = name,
            modifier = modifier.padding(16.dp),
            fontSize = 30.sp

        )
        Text(
            text = title,
            fontSize = 16.sp,
            style = TextStyle(fontWeight = FontWeight.Bold)
        )
    }
}

@Composable
fun ContactItem(image: Painter, text: String) {
    val imageSizeModifier = Modifier.size(width = 30.dp, height = 30.dp)
    Row(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = imageSizeModifier
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
fun Contact(number: String, email: String, linkedin: String){
    val image1 = painterResource(id = R.drawable.phone)
    val image2 = painterResource(id = R.drawable.email)
    val image3 = painterResource(id = R.drawable.linkedin)
    Column {
        ContactItem(image1, number)
        ContactItem(image2, email)
        ContactItem(image3, linkedin)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Card()
    }
}