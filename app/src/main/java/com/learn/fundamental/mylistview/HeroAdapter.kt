package com.learn.fundamental.mylistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.learn.fundamental.databinding.ItemRowHeroBinding
import com.learn.fundamental.myrecyclerview.Hero

class HeroAdapter internal constructor(val context : Context) : BaseAdapter() {
    internal var list = arrayListOf<Hero>()
    private lateinit var  bind : ItemRowHeroBinding
    override fun getCount(): Int = list.size

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null) {
            bind = ItemRowHeroBinding.inflate(LayoutInflater.from(context), parent, false)
            itemView = bind.root
        }

        val viewHolder = ViewHolder()
        val hero = getItem(position) as Hero
        viewHolder.bind(hero)
        return itemView
    }

    private inner class ViewHolder(){
        val name = bind.tvItemName
        val desc = bind.tvItemDetail
        val photo = bind.imgItemPhoto
        fun bind(hero: Hero) {
            name.text = hero.name
            desc.text = hero.detail
            photo.setImageResource(hero.photo)
        }
    }
}