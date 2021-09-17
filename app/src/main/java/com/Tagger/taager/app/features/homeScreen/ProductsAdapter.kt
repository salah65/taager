package com.Tagger.taager.app.features.homeScreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.Tagger.taager.data.core.Products
import com.Tagger.taager.databinding.ProductRvItemBinding
import com.Tagger.taager.domain.Model.Product

class ProductsAdapter(
    private var products: Products? = null,
    val onProductClickListener: (product: Product) -> Unit
) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    class ViewHolder(binding: ProductRvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding = ProductRvItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ProductRvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun updateData(products: Products) {
        this.products = products
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = products?.get(position)
        holder.binding.productName.text = currentItem?.name
        holder.binding.productPrice.text = currentItem?.price.toString()
        holder.binding.productCreatedAt.text = currentItem?.createdAt.toString()
        holder.itemView.setOnClickListener {
            currentItem?.let {
                onProductClickListener(it)
            }
        }
    }

    override fun getItemCount(): Int {
        return products?.size ?: 0
    }
}