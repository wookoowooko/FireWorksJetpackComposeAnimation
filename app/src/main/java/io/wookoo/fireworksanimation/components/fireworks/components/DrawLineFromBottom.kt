package io.wookoo.fireworksanimation.components.fireworks.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope

internal fun DrawScope.drawLineFromBottom(
    color: Color,
    centerX: Float,
    drawLineFromBottomToCenter: Animatable<Float, AnimationVector1D>,
    centerY: Float,
    outerRadius: Float
) {
    val startY = centerY + outerRadius.times(2f)
    val endY = startY - (drawLineFromBottomToCenter.value * (startY - centerY))

    val gradientColors = listOf(
        color,
        Color.White,
        color,
        Color.White,
        color,
        Color.White,
        Color.Red,
        Color.Blue
    )

    drawLine(
        brush = Brush.linearGradient(
            colors = gradientColors,
        ),
        start = Offset(centerX, startY),
        end = Offset(centerX, endY),
        strokeWidth = 4f
    )
}
