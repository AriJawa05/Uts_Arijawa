@file:Suppress("DEPRECATION")

package com.example.arijawauts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.arijawauts.ui.theme.ArijawaUtsTheme

// Data class Artwork (jika belum ada)
data class Artwork(val imageResourceId: Int, val title: String, val price: String, val year: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArijawaUtsTheme {
                ArijawaUtsApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArijawaUtsApp() {
    val artworks = listOf(
        Artwork(R.drawable.ari1, "Mobil SUV ", "Rp. 5 Milyar","2024"),
        Artwork(R.drawable.ari2, "Mobil Crossoverr", "Rp. 7 Milyar","2024"),
        Artwork(R.drawable.ari3, "Mobil Sedan", "Rp. 8 Milyar","2024"),
        Artwork(R.drawable.ari4, "Mobil Convertible", "Rp. 10 Milyar","2024"),
        Artwork(R.drawable.ari5, "Mobil Station Wagon", "Rp. 12 Milyar","2024"),
        Artwork(R.drawable.ari6, "Mobil Off road", "Rp. 15 Milyar","2024"),
        Artwork(R.drawable.ari7, "gran max ","Rp. 15 Milyar","2024"),
        Artwork(R.drawable.ari8, "thosiba ","Rp. 14 Milyar","2024"),
        Artwork(R.drawable.ari9, "cery", "Rp. 12 Milyar","2024"),
        Artwork(R.drawable.ari10, "bus", "Rp. 1 Milyar","2024")
        // Add more artworks here
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("PENJUALAN MOBIL", color = Color.White)
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF0000FF) // BLUE COLOR
                )
            )
        },
        bottomBar = {
            // Footer
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .padding(8.dp)
            ) {
                Text(
                    text = "Copyright @AriJawa",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // 2 kolom
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF0F0F0)) // Light gray background
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(artworks) { artwork ->
                ArtworkItem(artwork)
            }
        }
    }
}

@Composable
fun ArtworkItem(artwork: Artwork) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = artwork.imageResourceId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f), // Menjaga rasio aspek gambar
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = artwork.title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        // Menampilkan harga
        Text(
            text = artwork.price,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center
        )
    }
}