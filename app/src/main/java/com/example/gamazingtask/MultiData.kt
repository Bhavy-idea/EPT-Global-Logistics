package com.example.gamazingtask

import androidx.appcompat.widget.*

data class MultiData(
    var checkBoxVisibilityList : ArrayList<Boolean>,
    var checkBoxList: ArrayList<AppCompatCheckBox>,
    var radioButtonList: ArrayList<AppCompatRadioButton>,
    var editTextList: ArrayList<AppCompatEditText>,
)
