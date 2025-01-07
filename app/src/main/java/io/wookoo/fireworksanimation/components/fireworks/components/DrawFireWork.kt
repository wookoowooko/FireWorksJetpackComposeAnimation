package io.wookoo.fireworksanimation.components.fireworks.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import kotlin.math.cos
import kotlin.math.sin

internal fun DrawScope.drawFireWork(
    color: Color,
    centerX: Float,
    centerY: Float,
    innerRadius: Float,
    outerRadius: Float,
    lineCount: Int,
    drawFirstFireWorkFromInnerToOuter: Animatable<Float, AnimationVector1D>
) {
    val angleStep = 360f / lineCount

    val currentRadius =
        outerRadius + (outerRadius - innerRadius) * drawFirstFireWorkFromInnerToOuter.value

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

    for (i in 0 until lineCount) {
        val angleInRadians = Math.toRadians((i * angleStep).toDouble())

        val startX = centerX + innerRadius * cos(angleInRadians).toFloat()
        val startY = centerY + innerRadius * sin(angleInRadians).toFloat()

        val endX = centerX + currentRadius * cos(angleInRadians).toFloat()
        val endY = centerY + currentRadius * sin(angleInRadians).toFloat()

        drawLine(
            brush = Brush.linearGradient(
                gradientColors
            ),
            start = Offset(startX, startY),
            end = Offset(endX, endY),
            strokeWidth = 4f
        )
    }
}
