package com.example.gamazingtask.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamazingtask.adapter.*
import com.example.gamazingtask.databinding.ActivityScrollBehaviourBinding
import com.example.gamazingtask.model.*

class ScrollBehaviourActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollBehaviourBinding
    private var arrayListUser = ArrayList<User>()
    private lateinit var userAdapter: HeaderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScrollBehaviourBinding.inflate(layoutInflater)
        setContentView(binding.root)

        arrayListUser.add(User("Bhavyesh"))
        arrayListUser.add(User("Nikhil"))
        arrayListUser.add(User("Shivraj"))
        arrayListUser.add(User("Rahul"))
        arrayListUser.add(User("Jignesh"))
        arrayListUser.add(User("Vatsal"))

        arrayListUser.addAll(arrayListUser)
        arrayListUser.addAll(arrayListUser)
        arrayListUser.addAll(arrayListUser)
        arrayListUser.addAll(arrayListUser)

        userAdapter = HeaderAdapter(arrayListUser)
        binding.recyclerViewHeader.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewHeader.adapter = userAdapter

    }

}