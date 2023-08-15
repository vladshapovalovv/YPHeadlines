package com.example.ypheadlines.ui.component

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.ypheadlines.ui.theme.YPHeadlinesTheme

@Composable
fun YPHFilledButton(
    modifier: Modifier = Modifier,
    text: String, onClick: () -> Unit
) {
    Button(
        onClick = onClick, shape = RoundedCornerShape(size = Dimens.ButtonCornerRadius)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold)
        )
    }
}

@Composable
fun YPHTextButton(
    modifier: Modifier = Modifier,
    text: String, onClick: () -> Unit
) {
    TextButton(onClick = onClick) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold)
        )
    }
}

@Preview()
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ButtonsPreview() {
    YPHeadlinesTheme {
        Column {
            YPHFilledButton(text = "Click me") {}
            YPHTextButton(text = "Click me") {}
        }
    }
}