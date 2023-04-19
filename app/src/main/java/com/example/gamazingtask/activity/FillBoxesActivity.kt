package com.example.gamazingtask.activity

import android.annotation.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.View.OnTouchListener
import com.example.gamazingtask.*
import com.example.gamazingtask.databinding.ActivityFillBoxesBinding

class FillBoxesActivity : AppCompatActivity(), OnTouchListener {

    private lateinit var binding: ActivityFillBoxesBinding
    var xAxisList = arrayListOf<Float>()
    var yAxisList = arrayListOf<Float>()
    var viewList = arrayListOf<View>()
    var x = 0.0f
    var y = 0.0f
    var diameter = 75f
    var radius = diameter / 2

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFillBoxesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewFirst.setOnTouchListener(this)
        binding.viewSecond.setOnTouchListener(this)
        binding.viewThird.setOnTouchListener(this)
        binding.viewFourth.setOnTouchListener(this)
        binding.viewFive.setOnTouchListener(this)

        with(binding) {
            buttonGenerateBoxes.setOnClickListener {
                if (xAxisList.size != 5) {
                    for (i in 0 .. 4) {
                        val randomX = (0 .. 880).random()
                        val randomY = (0 .. 1600).random()

                        xAxisList.add(randomX.toFloat())
                        yAxisList.add(randomY.toFloat())

                        val view = LayoutInflater.from(it.context).inflate(R.layout.item_view, frameLayout, false)
                        view.x = xAxisList[i]
                        view.y = yAxisList[i]
                        frameLayout.addView(view)
                        viewList.add(view)
                    }
                }
                Log.d("data", viewList.toString())
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(v: View, event: MotionEvent?): Boolean {
        if (event != null) {

            when (event.action) {

                MotionEvent.ACTION_DOWN -> {
                    x = event.x
                    y = event.y
                }

                MotionEvent.ACTION_MOVE -> {

                    val distanceX = event.x - x
                    val distanceY = event.y - y

                    v.x = distanceX + v.x
                    v.y = distanceY + v.y

                    for (i in viewList.indices) {
                        if (v.x in (viewList[i].x - diameter) .. (viewList[i].x + 2 * diameter) && v.y in (viewList[i].y - diameter) .. (viewList[i].y + 2 * diameter)) {
                            v.x = viewList[i].x + radius
                            v.y = viewList[i].y + radius
                        }
                    }
                }
            }
        }
        return true
    }

}