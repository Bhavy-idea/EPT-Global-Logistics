package com.example.gamazingtask

import android.annotation.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.TextView
import com.example.gamazingtask.databinding.ActivityDynamicGridLayoutBinding

class DynamicGridLayout : AppCompatActivity() {

    private lateinit var binding: ActivityDynamicGridLayoutBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDynamicGridLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener {

        val num = binding.editTextUserInput.text.toString().toInt()

            binding.gridLayout.apply {

                binding.gridLayout.removeAllViews()

                rowCount = num
                columnCount = num

                for (i in 0 until num * num) {
                    val value = (1 .. 10).random()
                    val textView = TextView(context).apply {
                        text = value.toString()
                        textSize = 24f
                        gravity = Gravity.CENTER

                    }
                    binding.gridLayout.addView(textView, i)
                }
            }
        }
    }
}