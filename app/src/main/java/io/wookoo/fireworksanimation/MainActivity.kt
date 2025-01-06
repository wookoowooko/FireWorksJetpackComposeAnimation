package io.wookoo.fireworksanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import io.wookoo.fireworksanimation.ui.theme.FireWorksAnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FireWorksAnimationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Fireworks(modifier = Modifier.background(Color.Black).padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Fireworks(
    modifier: Modifier = Modifier
) {

    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
    ) {
        val (fireworkOne, fireworkTwo, fireworkThree, fireworkFour, fireworkFive) = createRefs()
        val ht1 = createGuidelineFromTop(0.06f)
        val ht2 = createGuidelineFromTop(0.22f)
        val ht3 = createGuidelineFromTop(0.3f)
        val ht4 = createGuidelineFromTop(0.4f)
        val ht5 = createGuidelineFromTop(0.52f)

        val vg1 = createGuidelineFromStart(0.05f)
        val vg2 = createGuidelineFromStart(0.4f)
        val vg4 = createGuidelineFromStart(0.4f)
        val vg5 = createGuidelineFromStart(0.45f)
        val vg6 = createGuidelineFromStart(0.23f)


        val fireworks = listOf(
            Firework(
                firstFireWorkColor = Color.Red,
                secondFireWorkColor = Color.Blue,
                lineColor = Color.White,
                constraintPair = Pair(ht1, vg2),
                reference = fireworkOne,
                durationTimeMillis = 150
            ),
            Firework(
                firstFireWorkColor = Color.Blue,
                secondFireWorkColor = Color.Cyan,
                lineColor = Color.Gray,
                constraintPair = Pair(ht2, vg1),
                reference = fireworkTwo,
                durationTimeMillis = 200
            ),
            Firework(
                firstFireWorkColor = Color.Green,
                secondFireWorkColor = Color.Yellow,
                lineColor = Color.Black,
                constraintPair = Pair(ht3, vg4),
                reference = fireworkThree,
                durationTimeMillis = 250
            ),
            Firework(
                firstFireWorkColor = Color.Magenta,
                secondFireWorkColor = Color.Red,
                lineColor = Color.LightGray,
                constraintPair = Pair(ht4, vg5),
                reference = fireworkFour,
                durationTimeMillis = 300
            ),
            Firework(
                firstFireWorkColor = Color.Yellow,
                secondFireWorkColor = Color.Red,
                lineColor = Color.DarkGray,
                constraintPair = Pair(ht5, vg6),
                reference = fireworkFive,
                durationTimeMillis = 350
            )
        )

        fireworks.forEach { firework ->
            FireWorkItem(
                lineColor = firework.lineColor,
                firstFireWorkColor = firework.firstFireWorkColor,
                secondFireWorkColor = firework.secondFireWorkColor,
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


