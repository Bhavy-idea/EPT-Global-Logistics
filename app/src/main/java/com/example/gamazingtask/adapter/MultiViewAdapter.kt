package com.example.gamazingtask.adapter

import android.annotation.*
import android.content.*
import android.graphics.Color
import android.util.Log
import android.view.*
import android.widget.*
import androidx.appcompat.widget.*
import androidx.core.view.*
import androidx.recyclerview.widget.RecyclerView
import com.example.gamazingtask.*
import com.example.gamazingtask.databinding.LayoutInflateBinding
import com.example.gamazingtask.model.*

var index = 0

class MultiViewAdapter(var arrayListOfMultiViews: ArrayList<MultiData>) : RecyclerView.Adapter<MultiViewAdapter.CheckBoxHolder>() {

    @SuppressLint("InflateParams")
    inner class CheckBoxHolder(var view: LayoutInflateBinding) : RecyclerView.ViewHolder(view.root) {

        fun bind(item : MultiData){

            val oldCheckBoxList = ArrayList(item.checkBoxList)

            view.buttonAddCheckbox.setOnClickListener {

                if (arrayListOfMultiViews[position].checkBoxList.size < 3) {
                    val addedCheckBox = addCheckbox(it.context)
                    view.linearLayoutCheckBox.addView(addedCheckBox)
                    arrayListOfMultiViews[position].checkBoxList.add(addedCheckBox)

                } else {
                    Toast.makeText(it.context, "Cannot add more then 3 items", Toast.LENGTH_SHORT).show()
                }

            }

            view.buttonAddRadioButton.setOnClickListener {

                if (arrayListOfMultiViews[position].radioButtonList.size < 3) {
                    val addedRadioButton = addRadioButton(it.context)
                    view.linearLayoutRadioButton.addView(addedRadioButton)
                    arrayListOfMultiViews[position].radioButtonList.add(addedRadioButton)
                }else {
                    Toast.makeText(it.context, "Cannot add more then 3 items", Toast.LENGTH_SHORT).show()
                }
            }

            view.buttonAddEditText.setOnClickListener {

                if (arrayListOfMultiViews[position].editTextList.size < 3) {
                    val addedEditText = addEditText(it.context)
                    view.linearLayoutEditText.addView(addedEditText)
                    arrayListOfMultiViews[position].editTextList.add(addedEditText)
                }else {
                    Toast.makeText(it.context, "Cannot add more then 3 items", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckBoxHolder {
        Log.d("data", "CREATE VIEW HOLDER CALLED $index")
        return CheckBoxHolder(LayoutInflateBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = arrayListOfMultiViews.size

    override fun onBindViewHolder(holder: CheckBoxHolder, position: Int) {


        holder.bind(arrayListOfMultiViews[position])

        holder.view.linearLayoutCheckBox.removeAllViews()
        holder.view.linearLayoutRadioButton.removeAllViews()
        holder.view.linearLayoutEditText.removeAllViews()


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