package com.example.fortisshisha.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fortisshisha.R
import com.example.fortisshisha.models.Apparat
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_item_layout.view.*

class HookahListAdapter  (
    var apparatList: List<Apparat>? = null,
    val addRemoveListener: ProductAddRemoveCallback? = null,
    val moreButtonClick: MoreButtonClick? = null)
    : RecyclerView.Adapter<HookahListAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = apparatList?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        apparatList?.get(position)?.let { holder.bind(it) }
    }

    fun setContext(context: Context) {
        this.context = context
    }

    inner class ViewHolder(inflater: LayoutInflater, parent: ViewGroup)
        : RecyclerView.ViewHolder(
        inflater.inflate(R.layout.product_item_layout, parent, false)) {

        private val productName = itemView.productNameTextView


        fun bind(apparat: Apparat) {
            productName.text = apparat.brandName

            itemView.addButton.setOnClickListener {
                if (!apparat.isAddedToCart()) {
                    apparat.addToCart(true)
                    itemView.addButton.text = "Убрать"
                    addRemoveListener?.onAddProduct()
                } else {
                    apparat.addToCart(false)
                    itemView.addButton.text = "В корзину"
                    addRemoveListener?.onRemoveProduct()
                }
            }

            itemView.moreButton.setOnClickListener {
                moreButtonClick?.moreItemClick(adapterPosition, apparat)
            }

            Picasso.with(itemView.context)
                .load(apparat.imgURL)
                .into(itemView.productImageView)
        }
    }
}