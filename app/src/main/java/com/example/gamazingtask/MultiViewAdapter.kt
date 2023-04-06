package com.example.gamazingtask

import android.annotation.*
import android.content.*
import android.graphics.Color
import android.util.Log
import android.view.*
import android.widget.*
import androidx.appcompat.widget.*
import androidx.core.view.*
import androidx.recyclerview.widget.RecyclerView
import com.example.gamazingtask.databinding.LayoutInflateBinding

var index = 0

class MultiViewAdapter(var arrayListOfMultiViews: ArrayList<MultiData>) : RecyclerView.Adapter<MultiViewAdapter.CheckBoxHolder>() {

    @SuppressLint("InflateParams")
    inner class CheckBoxHolder(var view: LayoutInflateBinding) : RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckBoxHolder {
        Log.d("data", "CREATE VIEW HOLDER CALLED $index")
        return CheckBoxHolder(LayoutInflateBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = arrayListOfMultiViews.size

    override fun onBindViewHolder(holder: CheckBoxHolder, position: Int) {

        holder.view.linearLayoutCheckBox.removeAllViews()
        holder.view.linearLayoutRadioButton.removeAllViews()
        holder.view.linearLayoutEditText.removeAllViews()

        val sizeOfCheckboxList = arrayListOfMultiViews[position].checkBoxList.size

        for (i in 0 until sizeOfCheckboxList) {
            holder.view.linearLayoutCheckBox.removeView(arrayListOfMultiViews[position].checkBoxList[i])
            holder.view.linearLayoutCheckBox.addView(arrayListOfMultiViews[position].checkBoxList[i], i)
        }

        val sizeOfRadiobuttonList = arrayListOfMultiViews[position].radioButtonList.size

        for (i in 0 until sizeOfRadiobuttonList) {
            holder.view.linearLayoutRadioButton.removeView(arrayListOfMultiViews[position].radioButtonList[i])
            holder.view.linearLayoutRadioButton.addView(arrayListOfMultiViews[position].radioButtonList[i], i)
        }

        val sizeOfEditTextList = arrayListOfMultiViews[position].editTextList.size

        for (i in 0 until sizeOfEditTextList) {
            holder.view.linearLayoutEditText.removeView(arrayListOfMultiViews[position].editTextList[i])
            holder.view.linearLayoutEditText.addView(arrayListOfMultiViews[position].editTextList[i], i)
        }

        holder.view.buttonAddCheckbox.setOnClickListener {

            if (arrayListOfMultiViews[position].checkBoxList.size < 3) {
                val addedCheckBox = addCheckbox(it.context)
                holder.view.linearLayoutCheckBox.addView(addedCheckBox)
                arrayListOfMultiViews[position].checkBoxList.add(addedCheckBox)

            } else {
                Toast.makeText(it.context, "Cannot add more then 3 items", Toast.LENGTH_SHORT).show()
            }

        }

        holder.view.buttonAddRadioButton.setOnClickListener {

            if (arrayListOfMultiViews[position].radioButtonList.size < 3) {
                val addedRadioButton = addRadioButton(it.context)
                holder.view.linearLayoutRadioButton.addView(addedRadioButton)
                arrayListOfMultiViews[position].radioButtonList.add(addedRadioButton)
            }else {
                Toast.makeText(it.context, "Cannot add more then 3 items", Toast.LENGTH_SHORT).show()
            }
        }

        holder.view.buttonAddEditText.setOnClickListener {

            if (arrayListOfMultiViews[position].editTextList.size < 3) {
                val addedEditText = addEditText(it.context)
                holder.view.linearLayoutEditText.addView(addedEditText)
                arrayListOfMultiViews[position].editTextList.add(addedEditText)
            }else {
                Toast.makeText(it.context, "Cannot add more then 3 items", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun addCheckbox(context: Context): AppCompatCheckBox {
        val newAddedCheckbox = LayoutInflater.from(context).inflate(R.layout.layout_checkbox, null, false) as AppCompatCheckBox
        newAddedCheckbox.setBackgroundColor(Color.parseColor(hexCodeGenerator()))
        return newAddedCheckbox
    }

    private fun addRadioButton(context: Context): AppCompatRadioButton {
        val newAddedRadiobutton = LayoutInflater.from(context).inflate(R.layout.layout_radiobutton, null, false) as AppCompatRadioButton
        newAddedRadiobutton.setBackgroundColor(Color.parseColor(hexCodeGenerator()))
        return newAddedRadiobutton
    }

    private fun addEditText(context: Context): AppCompatEditText {
        val newAddedEdittext = LayoutInflater.from(context).inflate(R.layout.layout_edittext, null, false) as AppCompatEditText
        newAddedEdittext.setBackgroundColor(Color.parseColor(hexCodeGenerator()))
        return newAddedEdittext
    }

}

fun hexCodeGenerator(): String {

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