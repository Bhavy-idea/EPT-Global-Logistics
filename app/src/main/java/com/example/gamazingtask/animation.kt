package com.example.gamazingtask

import android.view.View
import android.view.animation.*

class MyAnimation(view: View, r: Float) : Animation() {

    private val view: View
    private var cx = 0f
    private var cy // center x,y position of circular path
            = 0f

    private var prevX = 0f
    private var prevY // previous x,y position of image during animation
            = 0f
    private val r // radius of circle
            : Float
    private var prevDx = 0f
    private var prevDy = 0f


    init {
        this.view = view
        this.r = r
    }

    override fun initialize(width: Int, height: Int, parentWidth: Int, parentHeight: Int) {
        // calculate position of image center
        val cxView = width / 2
        val cyView = height / 2
        cx = (view.left + cxView).toFloat()
        cy = (view.top + cyView).toFloat()

        // set previous position to center
        prevX = cx
        prevY = cy
    }

    override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
        if (interpolatedTime == 0f) {
            t.matrix.setTranslate(prevDx, prevDy)
            return
        }
        val angleDeg = (interpolatedTime * 360f + 90) % 360
        val angleRad = Math.toRadians(angleDeg.toDouble()).toFloat()

        // r = radius, cx and cy = center point, a = angle (radians)
        val x = (cx + r * Math.cos(angleRad.toDouble())).toFloat()
        val y = (cy + r * Math.sin(angleRad.toDouble())).toFloat()
        val dx = prevX - x
        val dy = prevY - y
        prevX = x
        prevY = y
        prevDx = dx
        prevDy = dy
        t.matrix.setTranslate(dx, dy)
    }
}