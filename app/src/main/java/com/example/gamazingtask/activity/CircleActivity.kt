package com.example.gamazingtask.activity

import android.app.*
import android.os.Bundle
import android.view.*
import android.view.animation.*
import com.example.gamazingtask.*

class CircleActivity : Activity() {

    private lateinit var viewCircle : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circle)

        viewCircle = findViewById(R.id.viewCircle)


    }
}

//class CircleActivity : AppCompatActivity() {
//
//    private lateinit var viewBox: View
//    private lateinit var animationSet: AnimationSet
//
//    @SuppressLint("MissingInflatedId")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_circle)
//
//        viewBox = findViewById(R.id.viewCircle)
//
//        animationSet = AnimationSet(false)
//        val diagonalTranslateAnimation = TranslateAnimation(5f, 40f, 25f, 0f)
//        val diagonalTranslateAnimation2 = TranslateAnimation(40f, 200f, 25f, 0f)
//        val diagonalTranslateAnimation3 = TranslateAnimation(200f, 200f, 25f, 400f)
//        val diagonalTranslateAnimation4 = TranslateAnimation(5f, 40f, 25f, 0f)
//        val diagonalScaleAnimation = ScaleAnimation(
//            1f,
//            1.1f,
//            1f,
//            1.1f,
//            Animation.RELATIVE_TO_SELF,
//            0.3f,
//            Animation.RELATIVE_TO_PARENT,
//            0.4f
//        )
//
//        animationSet.addAnimation(diagonalScaleAnimation)
//        animationSet.addAnimation(diagonalTranslateAnimation)
//        animationSet.addAnimation(diagonalTranslateAnimation2)
//        animationSet.addAnimation(diagonalTranslateAnimation3)
//        animationSet.addAnimation(diagonalTranslateAnimation4)
//        animationSet.duration = 2000
//        viewBox.startAnimation(animationSet)
//
//    }
//}