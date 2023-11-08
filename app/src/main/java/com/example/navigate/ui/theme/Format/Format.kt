package com.example.navigate.ui.theme.Format

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.navigate.R

@Composable
fun FormatLaberHarga(subtotal: String, modifier: Modifier = Modifier){
    Text(text = stringResource(id = R.string.subtotal_price, subtotal),
        modifier = modifier,
        style = MaterialTheme.typography.headlineSmall
    )
}