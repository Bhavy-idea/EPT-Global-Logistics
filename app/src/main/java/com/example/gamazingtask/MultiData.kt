package com.example.gamazingtask

import androidx.appcompat.widget.*

data class MultiData(
    var isCheckboxChecked : ArrayList<Boolean>,
    var checkBoxList: ArrayList<AppCompatCheckBox>,
    var isRadioChecked : ArrayList<Boolean>,
    var radioButtonList: ArrayList<AppCompatRadioButton>,
    var editTextList: ArrayList<AppCompatEditText>,
    var filledEdiTextList : ArrayList<Boolean>,
)
