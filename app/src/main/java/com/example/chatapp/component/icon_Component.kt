package com.example.chatapp.component

import androidx.annotation.DrawableRes
import androidx.annotation.Size
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp

@Composable
fun IconComponentDrawable(
    @DrawableRes icon:Int,
    modifier: Modifier = Modifier,
    size: Dp,
    tint: Color = Color.Unspecified
) {
    Icon(
        painter = painterResource(id = icon),
        contentDescription = null,
        modifier = modifier.size(size),
        tint = tint
    )
}

@Composable
fun IconComponentImageVector(
    icon:ImageVector,
    modifier: Modifier = Modifier,
    size: Dp,
    tint: Color = Color.Unspecified
) {
    Icon(
        imageVector = icon,
        contentDescription = null,
        modifier = modifier.size(size),
        tint = tint
    )
}