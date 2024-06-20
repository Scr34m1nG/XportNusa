package com.adyatma.xportnusa.ui.buyerlist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.adyatma.xportnusa.R
import com.google.android.gms.analytics.ecommerce.Product


class ListAdapter (private val context: Context, private val productList: List<Product>, private val listener: OnItemClickListener) : RecyclerView.Adapter<CustomListAdapter.ProductViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val image: ImageView = itemView.findViewById(R.id.image)
        val title: TextView = itemView.findViewById(R.id.text)
        val minOrder: TextView = itemView.findViewById(R.id.listTime)
        val cardView: CardView = itemView.findViewById(R.id.cardView)

        init {
            cardView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.image.setImageResource(product.imageResource)
        holder.title.text = product.title
        holder.minOrder.text = "Min Order: ${product.minOrder}"
    }

    override fun getItemCount(): Int {
        return productList.size
    }

}