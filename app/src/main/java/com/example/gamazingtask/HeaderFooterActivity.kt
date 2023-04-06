package com.example.gamazingtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamazingtask.databinding.ActivityHeaderFooterBinding

class HeaderFooterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHeaderFooterBinding
    private var arrayListUser = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeaderFooterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        arrayListUser.add(User("Bhavyesh"))
        arrayListUser.add(User("Nikhil"))
        arrayListUser.add(User("Shivraj"))
        arrayListUser.add(User("Rahul"))
        arrayListUser.add(User("Jignesh"))
        arrayListUser.add(User("Vatsal"))

        binding.recyclerViewHeader.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewHeader.adapter = HeaderAdapter(arrayListUser)

    }
}