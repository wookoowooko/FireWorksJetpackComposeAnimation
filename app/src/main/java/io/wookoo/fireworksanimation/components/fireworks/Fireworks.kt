package io.wookoo.fireworksanimation.components.fireworks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Suppress("DestructuringDeclarationWithTooManyEntries")
@Composable
fun Fireworks(
    modifier: Modifier = Modifier,
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black.copy(0.5f))
    ) {
        val (
            fireworkOne, fireworkTwo, fireworkThree, fireworkFour, fireworkFive,
            fireworkSix, fireworkSeven, fireworkEight, fireworkNine, fireworkTen
        ) = createRefs()
        val ht1 = createGuidelineFromTop(0.06f)
        val ht2 = createGuidelineFromTop(0.22f)
        val ht3 = createGuidelineFromTop(0.3f)
        val ht4 = createGuidelineFromTop(0.4f)
        val ht5 = createGuidelineFromTop(0.52f)
        val ht6 = createGuidelineFromTop(0.6f)
        val ht7 = createGuidelineFromTop(0.68f)
        val ht8 = createGuidelineFromTop(0.76f)
        val ht9 = createGuidelineFromTop(0.84f)
        val ht10 = createGuidelineFromTop(0.42f)

        val vg1 = createGuidelineFromStart(0.05f)
        val vg2 = createGuidelineFromStart(0.4f)
        val vg3 = createGuidelineFromStart(0.4f)
        val vg5 = createGuidelineFromStart(0.45f)
        val vg6 = createGuidelineFromStart(0.23f)
        val vg7 = createGuidelineFromStart(0.23f)
        val vg8 = createGuidelineFromStart(0.13f)
        val vg9 = createGuidelineFromStart(0.3f)
        val vg10 = createGuidelineFromStart(0.7f)

        val fireworks = listOf(
            Firework(
                firstFireWorkColor = Color.Red,
                secondFireWorkColor = Color.Yellow,
                lineColor = Color.Magenta,
                constraintPair = Pair(ht1, vg2),
                reference = fireworkOne,
                durationTimeMillis = 150,
                innerRadius = 100f,
                outerRadius = 150f
            ),
            Firework(
                firstFireWorkColor = Color.Blue,
                secondFireWorkColor = Color.Cyan,
                lineColor = Color.Red,
                constraintPair = Pair(ht2, vg1),
                reference = fireworkTwo,
                durationTimeMillis = 180,
                innerRadius = 30f,
                outerRadius = 60f
            ),
            Firework(
                firstFireWorkColor = Color.Green,
                secondFireWorkColor = Color.Yellow,
                lineColor = Color.Yellow,
                constraintPair = Pair(ht3, vg3),
                reference = fireworkThree,
                durationTimeMillis = 190,
                innerRadius = 100f,
                outerRadius = 160f
            ),
            Firework(
                firstFireWorkColor = Color.Magenta,
                secondFireWorkColor = Color.Red,
                lineColor = Color.Blue,
                constraintPair = Pair(ht4, vg5),
                reference = fireworkFour,
                durationTimeMillis = 210,
                innerRadius = 30f,
                outerRadius = 60f
            ),
            Firework(
                firstFireWorkColor = Color.Yellow,
                secondFireWorkColor = Color.Green,
                lineColor = Color.Yellow,
                constraintPair = Pair(ht5, vg6),
                reference = fireworkFive,
                durationTimeMillis = 230,
                innerRadius = 120f,
                outerRadius = 200f
            ),
            Firework(
                firstFireWorkColor = Color.Yellow,
                secondFireWorkColor = Color.Blue,
                lineColor = Color.Cyan,
                constraintPair = Pair(ht6, vg6),
                reference = fireworkSix,
                durationTimeMillis = 250
            ),
            Firework(
                firstFireWorkColor = Color.Magenta,
                secondFireWorkColor = Color.Green,
                lineColor = Color.Red,
                constraintPair = Pair(ht7, vg7),
                reference = fireworkSeven,
                durationTimeMillis = 270
            ),
            Firework(
                firstFireWorkColor = Color.Red,
                secondFireWorkColor = Color.Cyan,
                lineColor = Color.Green,
                constraintPair = Pair(ht8, vg8),
                reference = fireworkEight,
                durationTimeMillis = 290,
                innerRadius = 30f,
                outerRadius = 60f
            ),
            Firework(
                firstFireWorkColor = Color.Yellow,
                secondFireWorkColor = Color.Blue,
                lineColor = Color.Cyan,
                constraintPair = Pair(ht9, vg9),
                reference = fireworkNine,
                durationTimeMillis = 310,
                innerRadius = 40f,
                outerRadius = 100f
            ),
            Firework(
                firstFireWorkColor = Color.Blue,
                secondFireWorkColor = Color.Yellow,
                lineColor = Color.Magenta,
                constraintPair = Pair(ht10, vg10),
                reference = fireworkTen,
                durationTimeMillis = 325,
                innerRadius = 30f,
                outerRadius = 60f
            )

        )

        val countOfAnimationInFireWorkItem = 6

        fireworks.forEach { firework ->
            FireWorkItem(
                innerRadius = firework.innerRadius,
                outerRadius = firework.outerRadius,
                countOfAnimationInFireWorkItem = countOfAnimationInFireWorkItem,
                lineColor = firework.lineColor.copy(0.6f),
                firstFireWorkColor = firework.firstFireWorkColor.copy(0.6f),
                secondFireWorkColor = firework.secondFireWorkColor.copy(0.6f),
                fireworkDurationTimeMillis = firework.durationTimeMillis,
                modifier = Modifier
                    .constrainAs(firework.reference) {
                        top.linkTo(firework.constraintPair.first)
                        start.linkTo(firework.constraintPair.second, margin = 16.dp)
                    }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun FireworksPreview() {
    Fireworks()
}
