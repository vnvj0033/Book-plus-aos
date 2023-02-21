package com.vnvj0033.bookplus.ui.intro

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.vnvj0033.bookplus.R
import com.vnvj0033.bookplus.ui.main.MainActivity
import com.vnvj0033.bookplus.ui.AppTheme


class IntroActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        actionBar?.hide()

        installSplashScreen()

        setContent {

        }

        Handler(mainLooper).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 1000)
    }

    @Composable
    private fun Intro() {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.mipmap.ic_launcher),
                modifier = Modifier
                    .size(128.dp),
                contentDescription = null)
        }

    }

    @Preview(showSystemUi = true)
    @Composable
    private fun Preview() {
        AppTheme {
            Intro()
        }
    }

}