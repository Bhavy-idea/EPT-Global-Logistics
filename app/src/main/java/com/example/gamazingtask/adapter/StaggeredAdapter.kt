package com.example.gamazingtask.adapter

import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.example.gamazingtask.databinding.LayoutImageviewBinding

class StaggeredAdapter(private var imageViewList : ArrayList<Int>) : RecyclerView.Adapter<StaggeredAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(var view : LayoutImageviewBinding) : RecyclerView.ViewHolder(view.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(LayoutImageviewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int = imageViewList.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.view.imageView.setImageResource(imageViewList[position])
    }


}