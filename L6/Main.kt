package com.example.l6
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.l6.ui.theme.L6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            L6Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CountryList(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

val GeoFont = FontFamily(
    Font(R.font.geo, FontWeight.Normal)
)

data class Country(
    val name: String,
    val flag: String
)

@Composable
fun CountryList(modifier: Modifier = Modifier) {
    val countries = listOf(
        Country("Finland", "🇫🇮"),
        Country("Japan", "🇯🇵"),
        Country("Brazil", "🇧🇷"),
        Country("Canada", "🇨🇦")
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        countries.forEach { country ->
            CountryCard(country = country)
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun CountryCard(country: Country) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = country.flag,
                fontSize = 56.sp,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            Text(
                text = country.name,
                fontSize = 24.sp,
                fontFamily = GeoFont,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}
