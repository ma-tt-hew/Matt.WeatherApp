package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.theme.DarkBlue
import com.example.weatherapp.ui.theme.LightGray
import com.example.weatherapp.ui.theme.VeryLightGray
import com.example.weatherapp.ui.theme.BrightYellow
import com.example.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // Replace Greeting here with Weather Page
                    WeatherPage()
                }
            }
        }
    }
}
// Step 2. Remove Greeting and replace with Weather Page
@Composable
fun WeatherPage() {
    // Step 5. Add this to a column
    Column(
        modifier = Modifier
            .fillMaxWidth()
            //step 6. Add padding and alignment
            .padding(top = 64.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        HeaderImage()
        MainInfo()
        InfoTable()
    }

}

//s7 Define the mian page component
@Composable
fun MainInfo() {
    //s8. Creta a column and add a text. Talk about special Characters. Also the colors file

    //s10 add padding to the modifeir
    Column(
        modifier = Modifier.padding(top = 24.dp),
        //s12
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //s9 work on th font of the tex

        // this section deals with the temp values
        Text(
            text = "11" + '\u00B0',
            color = BrightYellow,
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
        )

        //s11- Add the Next Text
        Text(
            text = "New York City",
            color = DarkBlue,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        //s13
        Text(
            text = "Rainy to Partly Cloudy. \n Winds WSW at 10-15 kph",
            color = Color.Gray,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 24.dp)
        )
    }

}

@Composable
fun InfoTable() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .background(
                VeryLightGray
            )
    ) {
        Row(Modifier.padding(16.dp)) {
            InfoItem(
                iconRes = R.drawable.ic_humidity,
                title = "Humidity",
                subtitle = "85%",
                modifier = Modifier.weight(1f)
            )
            InfoItem(
                iconRes = R.drawable.ic_sun_full,
                title = "UV index",
                subtitle = "2/10",
                modifier = Modifier.weight(1f)
            )

        }
        Divider(color = LightGray)
        //step 20: Adding modifier
        Row(Modifier.padding(16.dp)) {
            InfoItem(
                iconRes = R.drawable.ic_sun_half,
                title = "Sunrise",
                subtitle = "7.03 AM%",
                modifier = Modifier.weight(1f)
            )
            InfoItem(
                iconRes = R.drawable.ic_sun_half,
                title = "Sunset",
                subtitle = "4.28 PM",
                modifier = Modifier.weight(1f)
            )
        }
    }

}

@Composable
fun InfoItem(iconRes: Int, title: String, subtitle: String, modifier: Modifier) {
    Row(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.ic_humidity),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 8.dp)
                .width(40.dp)
        )
        Column() {
            Text(title, color = Color.Gray)
            Text(subtitle, color= DarkBlue, fontWeight = FontWeight.Bold)
        }
    }
}

// Step Three- Add Header Image Composable. Add Image to the res folder.
@Composable
fun HeaderImage() {

    // Build first in order for the image to render
    Image(
        painter = painterResource(id = R.drawable.ic_couple),
        contentDescription = null,
        //step6; add modifier to width of image
        modifier = Modifier.width(200.dp)
    )
}

// Step 1. Change the size of the default preview.
@Preview(showBackground = true, widthDp = 390, heightDp = 800)
@Composable
fun DefaultPreview() {
    WeatherAppTheme {
        WeatherPage()
    }
}