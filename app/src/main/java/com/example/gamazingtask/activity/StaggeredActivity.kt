package com.example.gamazingtask.activity

import android.os.*
import androidx.appcompat.app.*
import androidx.recyclerview.widget.*
import com.example.gamazingtask.*
import com.example.gamazingtask.adapter.*
import com.example.gamazingtask.databinding.*

data class HeroList(
    var image: Int,
    var name: String
)

class StaggeredActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStaggeredBinding
    private lateinit var staggeredAdapter: StaggeredAdapter
    var heroesList = ArrayList<HeroList>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStaggeredBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        heroesList.add(HeroList(R.drawable.img_1, "Black Panther"))
        heroesList.add(HeroList(R.drawable.img_2, "Batman"))
        heroesList.add(HeroList(R.drawable.img_3, "Black Adam"))
        heroesList.add(HeroList(R.drawable.img_4, "Black Panther"))
        heroesList.add(HeroList(R.drawable.img_5, "Groot"))
        heroesList.add(HeroList(R.drawable.img_6, "Black Panther"))
        heroesList.add(HeroList(R.drawable.img_7, "Black Widow"))
        heroesList.add(HeroList(R.drawable.img_8, "Moon Knight"))
        heroesList.add(HeroList(R.drawable.img_9, "Superman"))
        heroesList.add(HeroList(R.drawable.img_10, "Spiderman"))
        heroesList.add(HeroList(R.drawable.img_11, "Superman"))
        heroesList.add(HeroList(R.drawable.img_12, "Batman"))
        heroesList.add(HeroList(R.drawable.img_13, "Superman Vs Batman"))
        heroesList.add(HeroList(R.drawable.img_14, "Superman"))
        heroesList.add(HeroList(R.drawable.img_15, "Thor"))
        heroesList.add(HeroList(R.drawable.img_16, "Thor"))
        heroesList.add(HeroList(R.drawable.img_17, "Deadpool"))
        heroesList.add(HeroList(R.drawable.img_18, "Captain America"))
        heroesList.add(HeroList(R.drawable.img_19, "Wolverine"))
        heroesList.add(HeroList(R.drawable.img_20, "Thor"))
        heroesList.add(HeroList(R.drawable.img_21, "Iron man"))
        heroesList.add(HeroList(R.drawable.img_22, "Captain America"))

        staggeredAdapter = StaggeredAdapter(heroesList)
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerViewStaggered.layoutManager = layoutManager
        binding.recyclerViewStaggered.adapter = staggeredAdapter


//        binding.searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                binding.searchView.clearFocus()
//
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//            }
//
//        })

//        layoutManager.spanSizeLookup = object : SpanSizeLookup() {
//            override fun getSpanSize(position: Int): Int {
//                return if (position == 1) 6 else 2
//            }
//        }

    }
}