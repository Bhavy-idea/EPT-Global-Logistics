package com.example.gamazingtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamazingtask.databinding.ActivityMultipleInflateBinding

class MultipleInflateActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMultipleInflateBinding
    private var arrayListOfMultiViews = ArrayList<MultiData>()
    private lateinit var multiViewAdapter : MultiViewAdapter

    var checkBoxList = ArrayList<AppCompatCheckBox>()
    var radioButtonList = ArrayList<AppCompatRadioButton>()
    var editTextList = ArrayList<AppCompatEditText>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultipleInflateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for (i in 0..499){
            arrayListOfMultiViews.add(MultiData(checkBoxList, radioButtonList,editTextList))
        }

        multiViewAdapter = MultiViewAdapter(arrayListOfMultiViews)

        binding.recyclerViewMultipleView.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewMultipleView.adapter = multiViewAdapter


    }


}