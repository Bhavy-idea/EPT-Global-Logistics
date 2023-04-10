package com.example.gamazingtask.activity

import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamazingtask.*
import com.example.gamazingtask.adapter.*
import com.example.gamazingtask.databinding.ActivityMultipleInflateBinding
import com.example.gamazingtask.model.*

class MultipleInflateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMultipleInflateBinding
    private var arrayListOfMultiViews = ArrayList<MultiData>()
    private lateinit var multiViewAdapter: MultiViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultipleInflateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for (i in 0 .. 25) {

            val editTextList = ArrayList<AppCompatEditText>()
            val radioButtonList = ArrayList<AppCompatRadioButton>()
            val checkBoxList = ArrayList<AppCompatCheckBox>()

            val checkBox = LayoutInflater.from(this).inflate(R.layout.layout_checkbox, null, false) as AppCompatCheckBox
            val radioButton = LayoutInflater.from(this).inflate(R.layout.layout_radiobutton, null, false) as AppCompatRadioButton
            val editText = LayoutInflater.from(this).inflate(R.layout.layout_edittext, null, false) as AppCompatEditText

            checkBox.setBackgroundColor(Color.parseColor(hexCodeGenerator()))
            radioButton.setBackgroundColor(Color.parseColor(hexCodeGenerator()))
            editText.setBackgroundColor(Color.parseColor(hexCodeGenerator()))

            checkBoxList.add(checkBox)
            radioButtonList.add(radioButton)
            editTextList.add(editText)

            arrayListOfMultiViews.add(MultiData(checkBoxList, radioButtonList, editTextList))
        }

        multiViewAdapter = MultiViewAdapter(arrayListOfMultiViews)

        binding.recyclerViewMultipleView.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewMultipleView.adapter = multiViewAdapter

    }
}