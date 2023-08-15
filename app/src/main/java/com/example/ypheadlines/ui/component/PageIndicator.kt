package com.example.ypheadlines.ui.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.example.ypheadlines.ui.component.Dimens.IndicatorSize
import com.example.ypheadlines.ui.theme.md_theme_light_primary
import com.example.ypheadlines.ui.theme.md_theme_light_secondary

@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    pageCount: Int,
    selectedPage: Int,
    selectedColor: Color = md_theme_light_primary,
    unselectedColor: Color = md_theme_light_secondary,
    animationDurationMillis: Int = 400
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(pageCount) { page ->
            val color = if (page == selectedPage) selectedColor else unselectedColor
            val animatedColor by animateColorAsState(
                targetValue = color,
                animationSpec = tween(durationMillis = animationDurationMillis),
                label = "Page indicator page change"
            )
            Box(
                modifier = Modifier
                    .size(IndicatorSize)
                    .clip(CircleShape)
                    .background(color = animatedColor)
            )
        }
    }
}
