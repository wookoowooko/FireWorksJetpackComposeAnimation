package io.wookoo.fireworksanimation.components.fireworks.components
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope

internal fun DrawScope.eraseLineFromBottom(
    color: Color,
    centerX: Float,
    centerY: Float,
    eraseLineFromBottomToCenter: Animatable<Float, AnimationVector1D>,
    outerRadius: Float
) {
    val endY = centerY + eraseLineFromBottomToCenter.value * (outerRadius * 2f)

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
        start = Offset(centerX, centerY),
        end = Offset(centerX, endY),
        strokeWidth = 4f
    )

}
