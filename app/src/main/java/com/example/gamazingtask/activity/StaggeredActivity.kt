package com.example.gamazingtask.activity

import android.os.*
import androidx.appcompat.app.*
import androidx.recyclerview.widget.*
import com.example.gamazingtask.*
import com.example.gamazingtask.adapter.*
import com.example.gamazingtask.databinding.*

class StaggeredActivity : AppCompatActivity() {

    private lateinit var binding : ActivityStaggeredBinding
    private lateinit var staggeredAdapter: StaggeredAdapter
    var imageList = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStaggeredBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        imageList.add(R.drawable.img_1)
        imageList.add(R.drawable.img_2)
        imageList.add(R.drawable.img_3)
        imageList.add(R.drawable.img_4)
        imageList.add(R.drawable.img_5)
        imageList.add(R.drawable.img_6)
        imageList.add(R.drawable.img_7)
        imageList.add(R.drawable.img_8)
        imageList.add(R.drawable.img_9)
        imageList.add(R.drawable.img_10)
        imageList.add(R.drawable.img_11)
        imageList.add(R.drawable.img_12)
        imageList.add(R.drawable.img_13)
        imageList.add(R.drawable.img_14)
        imageList.add(R.drawable.img_15)
        imageList.add(R.drawable.img_16)
        imageList.add(R.drawable.img_17)
        imageList.add(R.drawable.img_18)
        imageList.add(R.drawable.img_19)
        imageList.add(R.drawable.img_20)
        imageList.add(R.drawable.img_21)
        imageList.add(R.drawable.img_22)

        staggeredAdapter = StaggeredAdapter(imageList)
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerViewStaggered.layoutManager = layoutManager
        binding.recyclerViewStaggered.adapter = staggeredAdapter


//        layoutManager.spanSizeLookup = object : SpanSizeLookup() {
//            override fun getSpanSize(position: Int): Int {
//                return if (position == 1) 6 else 2
//            }
//        }

    }
}