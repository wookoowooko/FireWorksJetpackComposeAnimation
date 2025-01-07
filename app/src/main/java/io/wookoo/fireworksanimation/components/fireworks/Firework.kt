package io.wookoo.fireworksanimation.components.fireworks

import androidx.compose.ui.graphics.Color
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope

data class Firework(
    val firstFireWorkColor: Color,
    val secondFireWorkColor: Color,
    val lineColor: Color,
    val constraintPair: Pair<ConstraintLayoutBaseScope.HorizontalAnchor, ConstraintLayoutBaseScope.VerticalAnchor>,
    val reference: ConstrainedLayoutReference,
    val durationTimeMillis: Int = 170,
    val innerRadius: Float = 80f,
    val outerRadius: Float = 120f
)
