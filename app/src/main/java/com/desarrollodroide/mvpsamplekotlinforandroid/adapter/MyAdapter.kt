package com.desarrollodroide.mvpsamplekotlinforandroid.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.desarrollodroide.mvpsamplekotlinforandroid.R
import com.desarrollodroide.mvpsamplekotlinforandroid.model.Data

class MyAdapter(private val dataset: List<Data>) : androidx.recyclerview.widget.RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(v: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(v) {
        val tvTitle: TextView = v.findViewById(R.id.tv_title)
        val tvSubtitle: TextView = v.findViewById(R.id.tv_subTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = dataset[position].title
        holder.tvSubtitle.text = dataset[position].subTitle
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}
