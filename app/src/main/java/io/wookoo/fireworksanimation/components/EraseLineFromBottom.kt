package io.wookoo.fireworksanimation.components
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.ui.geometry.Offset
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

    drawLine(
        color = color,
        start = Offset(centerX, centerY),
        end = Offset(centerX, endY),
        strokeWidth = 4f
    )
}





