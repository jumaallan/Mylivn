package com.mylivn.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mylivn.data.local.entities.Comics
import com.mylivn.databinding.ItemComicsBinding

/**
 * ComicsRecyclerViewAdapter
 *
 * This adapter is responsible for setting the comics list, as an horizontal view
 */
class ComicsRecyclerViewAdapter :
    PagingDataAdapter<Comics, ComicsRecyclerViewAdapter.ViewHolder>(
        ComicsDiffer
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemComicsBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    class ViewHolder(private val binding: ItemComicsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(comics: Comics) {
            binding.comics = comics
            binding.executePendingBindings()
        }
    }

    companion object ComicsDiffer : DiffUtil.ItemCallback<Comics>() {
        override fun areItemsTheSame(
            oldItem: Comics,
            newItem: Comics
        ): Boolean =
            oldItem.comicName == newItem.comicName

        override fun areContentsTheSame(
            oldItem: Comics,
            newItem: Comics
        ): Boolean = oldItem == newItem
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}