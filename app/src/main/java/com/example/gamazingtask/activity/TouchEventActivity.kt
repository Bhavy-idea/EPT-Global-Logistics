package com.example.gamazingtask.activity

import android.annotation.*
import android.graphics.Color
import android.os.*
import android.view.*
import android.view.View.*
import androidx.appcompat.app.*
import com.example.gamazingtask.*
import com.example.gamazingtask.databinding.*

class TouchEventActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTouchEventBinding
    private var listOfView = arrayListOf<View>()

    @SuppressLint("ClickableViewAccessibility", "UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTouchEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.view.setOnDragListener(dragListener)

//        binding.view.setOnLongClickListener{
//
//            val clipText = "This is our clipData text"
//            val item = ClipData.Item(clipText)
//            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
//            val data = ClipData(clipText,mimeTypes,item)
//
//            val dragShadowBuilder = View.DragShadowBuilder(it)
//            it.startDragAndDrop(data,dragShadowBuilder,it,0)
//
//            it.visibility = View.INVISIBLE
//            true
//        }

        binding.frameLayout.setOnTouchListener { _, event ->

            if (event.action == MotionEvent.ACTION_DOWN) {

                if (listOfView.size <= 4) {
                    val view = LayoutInflater.from(this).inflate(R.layout.item_view, null, false) as View
                    view.layoutParams = ViewGroup.LayoutParams(200, 200)
                    view.setBackgroundColor(Color.parseColor(hexCodeGenerator()))

                    view.x = event.x - 100
                    view.y = event.y - 100

                    listOfView.add(view)

                    view.setOnTouchListener(OnTouchListener { _, events ->

                        val x = events.x + (view.x-100)
                        val y = events.y + (view.y-100)

                        when (events.action) {
                            MotionEvent.ACTION_MOVE -> {
                                view.x = x
                                view.y = y
                            }

                        }
                        true
                    })

                    binding.frameLayout.addView(view)
                }
            }


            true
        }


//
////                    view.setOnDragListener { v, event ->
////
////                        val msg = "data"
////
////                        when(event.action){
////
////                            DragEvent.ACTION_DRAG_ENTERED -> {
////                                Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENTERED");
////                            }
////                            DragEvent.ACTION_DRAG_STARTED -> {
////                                Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENTERED");
////                            }
////                            DragEvent.ACTION_DRAG_ENDED -> {
////                                Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENTERED");
////                            }
////                            DragEvent.ACTION_DRAG_LOCATION -> {
////                                Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENTERED");
////                            }
////                            DragEvent.ACTION_DROP -> {
////                                Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENTERED");
////                            }
////
////                        }
////
////                        true
////                    }
//
//                    binding.frameLayout.addView(view)
//                }
//
//            }
//            true
//        }

    }

    private fun hexCodeGenerator(): String {

        val colorList = arrayListOf<Char>(
            'A',
            'B',
            'C',
            'D',
            'E',
            'F',
            '1',
            '2',
            '3',
            '4',
            '5',
            '6',
            '7',
            '8',
            '9',
            '0'
        )

        var colorCode = ""

        for (i in 0 .. 5) {
            val charactor = colorList.random()
            colorCode += charactor
        }

        return "#$colorCode"

    }

//    val dragListener = View.OnDragListener { v, event ->
//
//        when (event.action) {
//
//            DragEvent.ACTION_DRAG_STARTED -> {
//                event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
//            }
//
//            DragEvent.ACTION_DRAG_ENTERED -> {
//                v.invalidate()
//                true
//            }
//
//            DragEvent.ACTION_DRAG_LOCATION -> true
//            DragEvent.ACTION_DRAG_EXITED -> {
//                v.invalidate()
//                true
//            }
//
//            DragEvent.ACTION_DROP -> {
//
//                val item = event.clipData.getItemAt(0)
//                val dragData = item.text
//                Toast.makeText(this, "dragData", Toast.LENGTH_SHORT).show()
//                v.visibility = View.VISIBLE
//                true
//
//            }
//
//            else -> {
//                false
//            }
//        }
//
//    }

//    override fun onTouchEvent(event: MotionEvent): Boolean {
//        return when (MotionEventCompat.getActionMasked(event)) {
//
//            MotionEvent.ACTION_DOWN -> {
//                touchCount ++
//
//                Log.d("data", event.x.toString() + " " + event.y.toString())
//
////                if (touchCount <= 5) {
//                val view = LayoutInflater.from(this).inflate(R.layout.item_view, null, false) as View
//                view.x = view.left + event.x
//                view.y = view.top + event.y
//                view.layoutParams = ViewGroup.LayoutParams(150, 150)
//                binding.frameLayout.addView(view)
////                }
//
//                true
//            }
//
//            else -> super.onTouchEvent(event)
//        }
//    }

}