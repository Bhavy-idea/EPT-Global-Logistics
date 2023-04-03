package com.example.gamazingtask

import android.graphics.drawable.*
import android.os.*
import android.view.*
import android.view.animation.*
import android.view.animation.Animation.AnimationListener
import androidx.appcompat.app.*

class ZAnimationActivity : AppCompatActivity() {

    private lateinit var viewBox: View
    private lateinit var animationSet: AnimationSet
    private lateinit var animationSet2: AnimationSet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zanimation)

        var animationDrawable = AnimationDrawable()

        viewBox = findViewById<View?>(R.id.viewBox).apply {
            animationDrawable = background as AnimationDrawable
        }

        animationDrawable.setEnterFadeDuration(3000)
        animationDrawable.setExitFadeDuration(2500)
        animationDrawable.start()

        viewBox.post {
            val rightAnimation = TranslateAnimation(0f, 700f, 100f, 100f)
            rightAnimation.duration = 2000
            rightAnimation.fillAfter = true

            val diagonalTranslateAnimation = TranslateAnimation(700f, 0f, 100f, 800f)

            rightAnimation.setAnimationListener(object : AnimationListener {
                override fun onAnimationStart(animation: Animation?) {

                }

                override fun onAnimationEnd(animation: Animation?) {
                    animationSet = AnimationSet(false)

                    val diagonalScaleAnimation = ScaleAnimation(1f, 2f, 1f, 2f)

                    diagonalScaleAnimation.repeatCount = 1
                    diagonalScaleAnimation.repeatMode = Animation.REVERSE
                    diagonalScaleAnimation.fillAfter = true
                    diagonalScaleAnimation.duration = 1000

                    diagonalTranslateAnimation.duration = 2000
                    diagonalTranslateAnimation.fillAfter = true

                    animationSet.fillAfter = true

                    animationSet.addAnimation(diagonalScaleAnimation)
                    animationSet.addAnimation(diagonalTranslateAnimation)

                    viewBox.startAnimation(animationSet)
                }

                override fun onAnimationRepeat(animation: Animation?) {}

            })


            diagonalTranslateAnimation.setAnimationListener((object : AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    animationSet2 = AnimationSet(false)
                    val slideRightAnimation = TranslateAnimation(0f, 700f, 800f, 800f)

                    slideRightAnimation.fillAfter = true
                    slideRightAnimation.duration = 2000

                    val slideAlphaAnimation = AlphaAnimation(1f, 0f)
                    slideAlphaAnimation.duration = 2000
                    slideAlphaAnimation.fillAfter = true

                    animationSet.fillAfter = true
                    animationSet2.addAnimation(slideAlphaAnimation)
                    animationSet2.addAnimation(slideRightAnimation)

                    viewBox.startAnimation(animationSet2)
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }

            }))
            viewBox.startAnimation(rightAnimation)

        }

//        val height = resources.displayMetrics.heightPixels
//        val width = resources.displayMetrics.widthPixels

//        viewBox.animate().translationX(700f).setDuration(1000)
//            .withEndAction(Runnable {
//                viewBox.animate().translationX(370f).translationY(400f)
//                    .scaleX(1f).scaleX(2f).scaleY(1f).scaleY(2f).setDuration(1000)
//                    .withEndAction(
//                        Runnable {
//                            viewBox.animate().translationX(5f)
//                                .translationY(700f).scaleX(2f).scaleX(1f).scaleY(2f).scaleY(1f)
//                                .setDuration(1000).withEndAction(
//                                    Runnable {
//                                        viewBox.animate().translationX(700f).alpha(0f)
//                                            .setDuration(1000)
//                                    })
//                        })
//            })

//        animationSet.setAnimationListener(object : Animation.AnimationListener {
//            override fun onAnimationStart(animation: Animation?) {
//            }
//
//            override fun onAnimationEnd(animation: Animation?) {
//                val diagonalTranslateAnimation2 =
//                    TranslateAnimation(200f, 5f, 400f, 0f)
//                val diagonalScaleAnimation2 = ScaleAnimation(
//                    1.5f,
//                    1f,
//                    1.5f,
//                    1f,
//                )
//                diagonalScaleAnimation2.duration = 3000
//                diagonalTranslateAnimation2.duration = 3000
//                animationSet2.addAnimation(diagonalTranslateAnimation2)
//                animationSet2.addAnimation(diagonalScaleAnimation2)
//
//                viewBox.startAnimation(animationSet2)
//            }
//
//            override fun onAnimationRepeat(animation: Animation?) {
//            }
//
//        })

//        android:duration="4000"
//        android:fromXDelta="300"
//        android:fromYDelta="600"
//        android:toXDelta="5"
//        android:toYDelta="1000"

//        val objectAnimator = ObjectAnimator.ofFloat(viewBox,"translationY",-500f,0f)
//        objectAnimator.duration = 4000
//        objectAnimator.start()
//
//        val objectAnimator2 = ObjectAnimator.ofFloat(viewBox,"rotation",0f,360f)
//        objectAnimator2.duration = 4000
//        objectAnimator2.start()

//        var a = R.animator.anim_set

//        val animatorSet = AnimatorSet()
//        animatorSet.playTogether(objectAnimator)
//        animatorSet.start()

//        val scaleAnimation = AnimatorInflater.loadAnimator(
//            this, R.animator.anim_set
//        )
//        scaleAnimation.setTarget(viewBox)
//        scaleAnimation.start()
//
//        ObjectAnimator.ofFloat()
//        android:fromXDelta="5"
//        android:toXDelta="700"

//        val slideRight = AnimationUtils.loadAnimation(this, R.anim.side_right)
//        val topToBottom = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom)
//        viewBox.startAnimation(slideRight)
////        val animatorSet = (AnimatorInflater.loadAnimator(this, R.animator.anim_set) as AnimatorSet)
//
//        slideRight.setAnimationListener(object : Animation.AnimationListener {
//            override fun onAnimationStart(animation: Animation?) {
//
//            }
//
//            override fun onAnimationEnd(animation: Animation?) {
//                viewBox.startAnimation(topToBottom)
//            }
//
//            override fun onAnimationRepeat(animation: Animation?) {
//
//            }
//
//        })
//
//        val centerToBottom = AnimationUtils.loadAnimation(this, R.anim.center_to_bottom)
//
//        topToBottom.setAnimationListener(object : Animation.AnimationListener {
//            override fun onAnimationStart(animation: Animation?) {
//
//            }
//
//            override fun onAnimationEnd(animation: Animation?) {
//                viewBox.startAnimation(centerToBottom)
//            }
//
//            override fun onAnimationRepeat(animation: Animation?) {
//            }
//
//        })
//
//        val bottomLine = AnimationUtils.loadAnimation(this,R.anim.slide_bottom_line)
//
//        centerToBottom.setAnimationListener(object : Animation.AnimationListener {
//            override fun onAnimationStart(animation: Animation?) {
//
//            }
//
//            override fun onAnimationEnd(animation: Animation?) {
//                viewBox.startAnimation(bottomLine)
//            }
//
//            override fun onAnimationRepeat(animation: Animation?) {
//                TODO("Not yet implemented")
//            }
//
//        })


    }
}

//        viewBox.startAnimation(b)
//        viewBox.startAnimation(b)

//
//        val slideRight = AnimationUtils.loadAnimation(this,R.animator.anim_set)
//        viewBox.startAnimation(slideRight)

//        val topToDown = AnimationUtils.loadAnimation(this,R.anim.top_to_bottom)
//        slideRight.fillAfter = true
//        slideRight.isFillEnabled = true
//        viewBox.startAnimation(topToDown)

