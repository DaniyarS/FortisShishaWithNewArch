package com.example.fortisshisha.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fortisshisha.R
import com.example.fortisshisha.models.MainMenuCategory
import kotlinx.android.synthetic.main.main_menu_item.view.*

class MainMenuListAdapter
    (val categoryList: List<MainMenuCategory>,
     val itemClickListener: RecyclerViewItemClick? = null)
    : RecyclerView.Adapter<MainMenuListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = categoryList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categoryList[position])
    }

    inner class ViewHolder(inflater: LayoutInflater, parent: ViewGroup)
        : RecyclerView.ViewHolder(
        inflater.inflate(R.layout.main_menu_item, parent, false)) {
            private val categoryName = itemView.categoryNameTextView
        fun bind(category: MainMenuCategory) {
            categoryName.text = category.categoryName

            itemView.enterButton.setOnClickListener {
                itemClickListener?.itemClick(adapterPosition, category)
            }
        }
    }

    interface RecyclerViewItemClick {
        fun itemClick(position: Int, item: MainMenuCategory?)
    }
}