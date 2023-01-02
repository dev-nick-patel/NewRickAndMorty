package com.techhands.newrickandmorty

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.techhands.newrickandmorty.navigation.Navigation
import com.techhands.newrickandmorty.ui.theme.NewRickAndMortyTheme
import com.techhands.newrickandmorty.utils.DASHBOARD_SCREEN
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewRickAndMortyTheme {
               Surface(
                   modifier = Modifier
                       .fillMaxSize()
                       .background(MaterialTheme.colors.background)
               ) {
                   Navigation()
               }
            }
        }
    }
}

@Composable
fun SplashScreen(navController: NavController){
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    // Animation
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            // tween Animation
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                }))
        // Customize the delay time
        delay(3000L)
        navController.navigate(DASHBOARD_SCREEN)
    }
    // Logo
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.mipmap.ic_rick_logo),
            contentDescription = "Logo",
            modifier = Modifier
                .scale(scale.value)
                .width(200.dp)
                .height(200.dp))

    }
}


@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    NewRickAndMortyTheme {
        SplashScreen(navController = NavController(LocalContext.current))
    }
}