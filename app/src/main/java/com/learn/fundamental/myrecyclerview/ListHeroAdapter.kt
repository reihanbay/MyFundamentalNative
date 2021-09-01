package com.learn.fundamental.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.learn.fundamental.R

class ListHeroAdapter(private val listHero : ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>(){
    private lateinit var onItemClick : OnItemClick
    fun setOnItemClick(onItemClick: OnItemClick) {
        this.onItemClick = onItemClick
    }
    interface OnItemClick {
        fun onItemClicked(data: Hero)
    }
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListHeroAdapter.ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero,parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val hero = listHero[position]

        Glide.with(holder.itemView.context)
            .load(hero.photo)
            .apply(RequestOptions().override(55,55))
            .into(holder.imgPhoto)

        holder.tvName.text = hero.name
        holder.tvDetail.text = hero.detail
        holder.itemView.setOnClickListener { onItemClick.onItemClicked(hero)}
    }

    override fun getItemCount(): Int = listHero.size

}