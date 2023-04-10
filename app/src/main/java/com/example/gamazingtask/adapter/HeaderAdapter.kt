package com.example.gamazingtask.adapter

import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.example.gamazingtask.databinding.LayoutFooterBinding
import com.example.gamazingtask.databinding.LayoutHeaderBinding
import com.example.gamazingtask.databinding.LayoutUserBinding
import com.example.gamazingtask.model.*

class HeaderAdapter(private var userList : ArrayList<User>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var HEADER = 1
    private var MIDDLE = 2
    private var FOOTER = 3

    inner class HeaderViewHolder(val view : LayoutHeaderBinding) : RecyclerView.ViewHolder(view.root){
        fun bindHeader(){
        }
    }
    inner class FooterViewHolder(val view : LayoutFooterBinding) : RecyclerView.ViewHolder(view.root){
        fun bindFooter(){

        }
    }
    inner class UserViewHolder(val view : LayoutUserBinding) : RecyclerView.ViewHolder(view.root){
        fun bindUser(name: String) {
            view.textViewUser.text = name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType == HEADER){
            HeaderViewHolder(LayoutHeaderBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        }else if (viewType == MIDDLE){
            UserViewHolder(LayoutUserBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        }else{
            FooterViewHolder(LayoutFooterBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(position){
            0 -> HEADER
            userList.size + 1 -> FOOTER
            else -> MIDDLE
        }
    }

    override fun getItemCount(): Int = userList.size + 2

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)){
            HEADER -> (holder as HeaderViewHolder).bindHeader()
            MIDDLE -> (holder as UserViewHolder).bindUser(userList[position-1].name)
            FOOTER -> (holder as FooterViewHolder).bindFooter()
        }
    }

}