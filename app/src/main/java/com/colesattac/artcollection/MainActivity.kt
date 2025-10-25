package com.colesattac.artcollection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.colesattac.artcollection.ui.theme.ArtCollectionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtCollectionTheme {
                // Используем Surface как основной контейнер
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtApp() // Запускаем главный Composable нашего приложения
                }
            }
        }
    }
}

/**
 * Главный Composable, который управляет навигацией между экранами.
 */
@Composable
fun ArtApp() {
    // Состояние для хранения ID выбранного изображения. null, если ничего не выбрано.
    var selectedImageResId by remember { mutableStateOf<Int?>(null) }

    // Если изображение выбрано (не null), показываем полноэкранный режим.
    if (selectedImageResId != null) {
        FullScreenImageViewer(
            imageResId = selectedImageResId!!, // !! безопасно, так как мы проверили на null
            onDismiss = { selectedImageResId = null } // Сбрасываем состояние для возврата
        )
    } else {
        // Иначе показываем экран галереи.
        ArtCollectionScreen(
            onImageClick = { imageId ->
                selectedImageResId = imageId // При клике обновляем состояние
            }
        )
    }
}

@Composable
fun ArtCollectionScreen(onImageClick: (Int) -> Unit) {
    val artCollection = remember { getArtCollection() }
    var currentIndex by remember { mutableStateOf(0) }

    val currentArtwork = artCollection[currentIndex]
    val isPreviousEnabled = currentIndex > 0
    val isNextEnabled = currentIndex < artCollection.size - 1

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { onImageClick(currentArtwork.imageResId) }
            ) {
                Image(
                    painter = painterResource(id = currentArtwork.imageResId),
                    contentDescription = currentArtwork.title,
                    modifier = Modifier.padding(16.dp)
                )
            }
            Spacer(modifier = Modifier.height(24.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = currentArtwork.title,
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = "${currentArtwork.author} (${currentArtwork.year})",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = currentArtwork.detailedInfo,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { if (isPreviousEnabled) currentIndex-- },
                enabled = isPreviousEnabled,
                modifier = Modifier.weight(1f)
            ) {
                Text("Назад")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = { if (isNextEnabled) currentIndex++ },
                enabled = isNextEnabled,
                modifier = Modifier.weight(1f)
            ) {
                Text("Далее")
            }
        }
    }
}

@Composable
fun FullScreenImageViewer(
    @DrawableRes imageResId: Int,
    onDismiss: () -> Unit
) {
    androidx.activity.compose.BackHandler { onDismiss() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .clickable { onDismiss() },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = "Full screen image",
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxSize()
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtCollectionTheme {
        ArtCollectionScreen(onImageClick = {})
    }
}
