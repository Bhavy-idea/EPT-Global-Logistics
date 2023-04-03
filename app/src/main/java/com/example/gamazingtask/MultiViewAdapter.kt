package com.example.gamazingtask

import android.annotation.*
import android.graphics.Color
import android.util.Log
import android.view.*
import android.widget.*
import androidx.appcompat.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.gamazingtask.databinding.LayoutInflateBinding

var index = 0

class MultiViewAdapter(var arrayListOfMultiViews: ArrayList<MultiData>) : RecyclerView.Adapter<MultiViewAdapter.CheckBoxHolder>() {

    var counter = 0

    @SuppressLint("InflateParams")
    inner class CheckBoxHolder(var view: LayoutInflateBinding) : RecyclerView.ViewHolder(view.root) {

        init {

            Log.d("data", "HOLDER CALLED $index")
            val editTextList = ArrayList<AppCompatEditText>()
            val radioButtonList = ArrayList<AppCompatRadioButton>()
            val checkBoxList = ArrayList<AppCompatCheckBox>()

            val checkBox = LayoutInflater.from(itemView.context).inflate(R.layout.layout_checkbox, null, false) as AppCompatCheckBox
            val radioButton = LayoutInflater.from(itemView.context).inflate(R.layout.layout_radiobutton, null, false) as AppCompatRadioButton
            val editText = LayoutInflater.from(itemView.context).inflate(R.layout.layout_edittext, null, false) as AppCompatEditText

            checkBox.setBackgroundColor(Color.parseColor(hexCodeGenerator()))
            view.linearLayoutCheckBox.addView(checkBox)
            radioButton.setBackgroundColor(Color.parseColor(hexCodeGenerator()))
            view.linearLayoutRadioButton.addView(radioButton)
            editText.setBackgroundColor(Color.parseColor(hexCodeGenerator()))
            view.linearLayoutEditText.addView(editText)

            checkBoxList.add(checkBox)
            radioButtonList.add(radioButton)
            editTextList.add(editText)

            arrayListOfMultiViews[counter].checkBoxList = checkBoxList
            arrayListOfMultiViews[counter].radioButtonList = radioButtonList
            arrayListOfMultiViews[counter].editTextList = editTextList

            counter ++

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckBoxHolder {
        Log.d("data", "CREATE VIEW HOLDER CALLED $index")
        return CheckBoxHolder(LayoutInflateBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = 26

    override fun onBindViewHolder(holder: CheckBoxHolder, position: Int) {

        Log.d("data", "BIND VIEW HOLDER CALLED ${index ++}")

        holder.view.buttonAddCheckbox.setOnClickListener {

            if (arrayListOfMultiViews[position].checkBoxList.size < 3) {

                val newAddedCheckbox = LayoutInflater.from(it.context).inflate(R.layout.layout_checkbox, null, false) as AppCompatCheckBox

                newAddedCheckbox.setBackgroundColor(Color.parseColor(hexCodeGenerator()))

                holder.view.linearLayoutCheckBox.addView(newAddedCheckbox)
//
                arrayListOfMultiViews[position].checkBoxList.add(newAddedCheckbox)

                Log.d("data", arrayListOfMultiViews[position].checkBoxList.toString())

            } else {
                Toast.makeText(it.context, arrayListOfMultiViews[position].checkBoxList.size.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        holder.view.buttonAddRadioButton.setOnClickListener {

            if (arrayListOfMultiViews[position].radioButtonList.size < 3) {
                val newAddedRadiobutton = LayoutInflater.from(it.context).inflate(R.layout.layout_radiobutton, null, false) as AppCompatRadioButton

                newAddedRadiobutton.setBackgroundColor(Color.parseColor(hexCodeGenerator()))

                holder.view.linearLayoutRadioButton.addView(newAddedRadiobutton)

                arrayListOfMultiViews[position].radioButtonList.add(newAddedRadiobutton)

            }
        }

        holder.view.buttonAddEditText.setOnClickListener {

            if (arrayListOfMultiViews[position].editTextList.size < 3) {
                val newAddedEdittext = LayoutInflater.from(it.context).inflate(R.layout.layout_edittext, null, false) as AppCompatEditText

                newAddedEdittext.setBackgroundColor(Color.parseColor(hexCodeGenerator()))

                holder.view.linearLayoutEditText.addView(newAddedEdittext)

                arrayListOfMultiViews[position].editTextList.add(newAddedEdittext)

            }
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

}