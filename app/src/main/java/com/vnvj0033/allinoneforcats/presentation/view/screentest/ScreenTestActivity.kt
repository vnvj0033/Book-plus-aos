package com.vnvj0033.allinoneforcats.presentation.view.screentest

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.vnvj0033.allinoneforcats.R

class ScreenTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_test)

        val dimen = resources.getDimension(R.dimen.fab_margin).pxToDp()

        findViewById<TextView>(R.id.textView).text = dimen.toString()
    }
}

private fun Float.pxToDp(): Float =
    this / Resources.getSystem().displayMetrics.density