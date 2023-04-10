package com.example.gamazingtask.activity

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.gamazingtask.*

class GlowButtonActivity : AppCompatActivity() {

    lateinit var button : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glow_button)

        var animationDrawable = AnimationDrawable()

        button = findViewById<AppCompatButton?>(R.id.btnGlowBg).apply {
            animationDrawable = background as AnimationDrawable
        }

        animationDrawable.setEnterFadeDuration(3000)
        animationDrawable.setExitFadeDuration(2500)
        animationDrawable.start()

    }
}