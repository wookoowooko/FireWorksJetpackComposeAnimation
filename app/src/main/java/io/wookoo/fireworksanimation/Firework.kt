package io.wookoo.fireworksanimation

import androidx.compose.ui.graphics.Color
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope

data class Firework(
    val firstFireWorkColor: Color,
    val secondFireWorkColor: Color,
    val lineColor: Color,
    val constraintPair: Pair<ConstraintLayoutBaseScope.HorizontalAnchor, ConstraintLayoutBaseScope.VerticalAnchor>,
    val reference: ConstrainedLayoutReference,
    val durationTimeMillis: Int = 170
)