package io.wookoo.fireworksanimation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.wookoo.fireworksanimation.components.drawFireWork
import io.wookoo.fireworksanimation.components.drawLineFromBottom
import io.wookoo.fireworksanimation.components.eraseFireWork
import io.wookoo.fireworksanimation.components.eraseLineFromBottom
import kotlinx.coroutines.delay


@Composable
fun FireWorkItem(
    firstFireWorkColor: Color,
    secondFireWorkColor: Color,
    lineColor: Color,
    fireworkDurationTimeMillis: Int = 170,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(
        modifier = modifier
            .size(150.dp)
    ) {
        val centerX = constraints.maxWidth / 2f
        val centerY = constraints.maxHeight / 2f
        val innerRadius = 80f
        val outerRadius = 120f
        val lineCount = 10
        val drawLineFromBottomToCenter = remember { Animatable(0f) }
        val eraseLineFromBottomToCenter = remember { Animatable(1f) }
        val drawFireWork = remember { Animatable(0f) }
        val eraseFireWork = remember { Animatable(1f) }
        val drawFireWork2 = remember { Animatable(0f) }
        val eraseFireWork2 = remember { Animatable(1f) }
        val animationCount = 6

        val animationState =
            produceState(initialValue = 0) {
                while (value < animationCount) {
                    value += 1
                    delay(fireworkDurationTimeMillis.toLong())
                }
            }

        LaunchedEffect(animationState.value) {
            when (animationState.value) {
                1 -> {
                    drawLineFromBottomToCenter.animateTo(
                        targetValue = 1f,
                        animationSpec = tween(
                            durationMillis = fireworkDurationTimeMillis,
                            easing = LinearEasing
                        )
                    )
                }

                2 -> {
                    eraseLineFromBottomToCenter.animateTo(
                        targetValue = 0f,
                        animationSpec = tween(
                            durationMillis = fireworkDurationTimeMillis,
                            easing = LinearEasing
                        )
                    )
                }

                3 -> {
                    drawFireWork.animateTo(
                        targetValue = 1f,
                        animationSpec = tween(
                            durationMillis = fireworkDurationTimeMillis,
                            easing = LinearEasing
                        )
                    )
                }

                4 -> {
                    eraseFireWork.animateTo(
                        targetValue = 0f,
                        animationSpec = tween(
                            durationMillis = fireworkDurationTimeMillis,
                            easing = LinearEasing
                        )
                    )
                }

                5 -> {
                    drawFireWork2.animateTo(
                        targetValue = 1f,
                        animationSpec = tween(
                            durationMillis = fireworkDurationTimeMillis,
                            easing = LinearEasing
                        )
                    )
                }

                6 -> {
                    eraseFireWork2.animateTo(
                        targetValue = 0f,
                        animationSpec = tween(
                            durationMillis = fireworkDurationTimeMillis,
                            easing = LinearEasing
                        )
                    )
                }
            }
        }

        Canvas(
            modifier = Modifier.matchParentSize()
        ) {
            when (animationState.value) {
                1 -> drawLineFromBottom(
                    centerX = centerX,
                    drawLineFromBottomToCenter = drawLineFromBottomToCenter,
                    centerY = centerY,
                    outerRadius = outerRadius,
                    color = lineColor
                )

                2 -> eraseLineFromBottom(
                    centerX = centerX,
                    centerY = centerY,
                    eraseLineFromBottomToCenter = eraseLineFromBottomToCenter,
                    outerRadius = outerRadius,
                    color = lineColor
                )

                3 -> drawFireWork(
                    color = firstFireWorkColor,
                    centerX = centerX,
                    centerY = centerY,
                    innerRadius = innerRadius,
                    outerRadius = outerRadius,
                    lineCount = lineCount,
                    drawFirstFireWorkFromInnerToOuter = drawFireWork
                )

                4 -> eraseFireWork(
                    color = firstFireWorkColor,
                    centerX = centerX,
                    centerY = centerY,
                    innerRadius = innerRadius,
                    outerRadius = outerRadius,
                    lineCount = lineCount,
                    eraseFirstFireWorkFromInnerToOuter = eraseFireWork
                )

                5 -> drawFireWork(
                    color = secondFireWorkColor,
                    centerX = centerX,
                    centerY = centerY,
                    innerRadius = innerRadius,
                    outerRadius = outerRadius,
                    lineCount = lineCount,
                    drawFirstFireWorkFromInnerToOuter = drawFireWork2
                )

                6 -> eraseFireWork(
                    color = secondFireWorkColor,
                    centerX = centerX,
                    centerY = centerY,
                    innerRadius = innerRadius,
                    outerRadius = outerRadius,
                    lineCount = lineCount,
                    eraseFirstFireWorkFromInnerToOuter = eraseFireWork2
                )
            }
        }
    }
}

