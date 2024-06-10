package com.example.article

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.article.bunga
import com.example.myapplication.bunga

class ListManagerAdapter(private val listManager: ArrayList<bunga>) : RecyclerView.Adapter<ListManagerAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    fun setOnItemClickCallback(onItem: OnItemClickCallback) {
        onItemClickCallback = onItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_manager, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listManager.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (
            name, description, photo
        ) = listManager[position]

        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listManager[holder.adapterPosition]) }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: bunga)
    }
}