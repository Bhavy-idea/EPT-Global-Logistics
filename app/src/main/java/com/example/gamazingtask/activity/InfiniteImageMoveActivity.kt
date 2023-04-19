package com.example.gamazingtask.activity

import android.annotation.*
import android.os.*
import android.util.*
import androidx.appcompat.app.AppCompatActivity
import android.view.MotionEvent
import android.widget.*
import androidx.core.os.*
import com.example.gamazingtask.*
import com.example.gamazingtask.adapter.*
import com.example.gamazingtask.databinding.ActivityInfiniteImageMoveBinding
import kotlinx.coroutines.*
import kotlin.math.*

data class CoOrdinates(
    var x: Float,
    var y: Float,
)

class InfiniteImageMoveActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfiniteImageMoveBinding
    private var coOrdinatesList = ArrayList<CoOrdinates>()

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfiniteImageMoveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView.setOnTouchListener { v, event ->

            when (event.action) {

                MotionEvent.ACTION_MOVE -> {
                    v.x = (event.x - 100) + (v.x - 50)
                    v.y = (event.y - 100) + (v.y - 50)

                    coOrdinatesList.add(CoOrdinates(v.x, v.y))
                }

                MotionEvent.ACTION_UP -> {
                    runInfinite()
                    Log.d("data","UP")
                    coOrdinatesList.clear()
                    Log.d("data","CLEAR")
                }
            }
            true
        }
    }

    private fun runInfinite() {
        for (i in 0 until coOrdinatesList.size) {
           run(coOrdinatesList[i].x,coOrdinatesList[i].y)
        }
    }

    private fun run(x: Float, y: Float) {
        Handler().postDelayed({
            binding.imageView.x = x
            binding.imageView.y = y
        },200)
    }


}

//            val translateAnimation = TranslateAnimation(coOrdinatesList[i-1].x, coOrdinatesList[i].x, coOrdinatesList[i-1].y, coOrdinatesList[i].y)
//            translateAnimation.duration = 100
//            binding.imageView.startAnimation(translateAnimation)

//
//binding.imageView.animate().x(coOrdinatesList[i].x).y(coOrdinatesList[i].y).setDuration(400).withEndAction(
//Runnable {
//    binding.imageView.animate().x(coOrdinatesList[i].x).y(coOrdinatesList[i].y).setDuration(400)
//}
//).withEndAction {
//    binding.imageView.animate().x(coOrdinatesList[i].x).y(coOrdinatesList[i].y).setDuration(400)
//}

