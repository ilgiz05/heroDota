package com.example.lesson11.ui.adaptrers

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson11.databinding.RecyclerviewItemBinding
import com.example.lesson11.model.Model
import com.example.lesson11.ui.click.ItemClick

class RecyclerAdapter:
    ListAdapter<Model, RecyclerAdapter.ViewHolder>(DiffUtilCallBack)
{

    lateinit var itemClick: ItemClick
    fun onItemClickListener(itemClick: ItemClick) {
        this.itemClick = itemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            RecyclerviewItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class ViewHolder(private val binding: RecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: Model) {
            binding.oneTxText.text = model.name
            itemView.setOnClickListener {
                itemClick.onItemClickListener(model)
            }
        }
    }

    object DiffUtilCallBack : DiffUtil.ItemCallback<Model>() {
        override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
            return oldItem.name === newItem.name
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
            return oldItem === newItem
        }
    }

}

