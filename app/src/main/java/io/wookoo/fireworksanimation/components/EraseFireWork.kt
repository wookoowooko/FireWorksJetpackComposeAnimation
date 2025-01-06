package io.wookoo.fireworksanimation.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import kotlin.math.cos
import kotlin.math.sin

internal fun DrawScope.eraseFireWork(
    color: Color,
    centerX: Float,
    centerY: Float,
    innerRadius: Float,
    outerRadius: Float,
    lineCount: Int,
    eraseFirstFireWorkFromInnerToOuter: Animatable<Float, AnimationVector1D>
) {
    val angleStep = 360f / lineCount

    val currentRadius =
        outerRadius - (outerRadius - innerRadius) * eraseFirstFireWorkFromInnerToOuter.value

    for (i in 0 until lineCount) {
        val angleInRadians = Math.toRadians((i * angleStep).toDouble())

        val startX = centerX + outerRadius * cos(angleInRadians).toFloat()
        val startY = centerY + outerRadius * sin(angleInRadians).toFloat()

        val endX = centerX + currentRadius * cos(angleInRadians).toFloat()
        val endY = centerY + currentRadius * sin(angleInRadians).toFloat()

        drawLine(
            color = color,
            start = Offset(startX, startY),
            end = Offset(endX, endY),
            strokeWidth = 4f
        )
    }
}
