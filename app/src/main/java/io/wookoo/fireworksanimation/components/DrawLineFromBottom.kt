package io.wookoo.fireworksanimation.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.ui.geometry.Offset
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

    drawLine(
        color = color,
        start = Offset(centerX, startY),
        end = Offset(centerX, endY),
        strokeWidth = 4f
    )
}