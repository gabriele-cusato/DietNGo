package com.gabrielecusato.dietngo.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gabrielecusato.dietngo.ui.theme.DietNGoTheme

/** Pagina iniziale dell'app, per ora vuota: la mostra MainActivity all'avvio. */
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    )
}

// Anteprima per Android Studio, nel tema chiaro e nel tema scuro
@Preview(name = "Chiaro")
@Preview(name = "Scuro", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun HomeScreenPreview() {
    DietNGoTheme {
        HomeScreen()
    }
}
