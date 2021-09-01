package com.learn.fundamental.mylistview

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.learn.fundamental.R
import com.learn.fundamental.databinding.ActivityMyListViewBinding
import com.learn.fundamental.myrecyclerview.Hero

class MyListViewActivity : AppCompatActivity() {
    private lateinit var bind : ActivityMyListViewBinding
    private lateinit var  adapter : HeroAdapter
    private lateinit var dataName : Array<String>
    private lateinit var dataDesc : Array<String>
    private lateinit var dataPhoto : TypedArray
    private var heroes = arrayListOf<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMyListViewBinding.inflate(LayoutInflater.from(this))
        setContentView(bind.root)
        adapter = HeroAdapter(this)
        bind.lv.adapter = adapter

        prepare()
        addItem()

        bind.lv.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, heroes[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name)
        dataDesc = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
    }

    private fun addItem() {
        for (p in dataName.indices) {
            val hero =Hero(dataName[p], dataDesc[p], dataPhoto.getResourceId(p, -1))
            heroes.add(hero)
        }
        adapter.list = heroes
    }
}