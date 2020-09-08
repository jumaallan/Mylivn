package com.mylivn.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mylivn.data.models.HeroComics
import com.mylivn.databinding.ItemComicsBinding

/**
 * ComicsRecyclerViewAdapter
 *
 * This adapter is responsible for setting the comics list, as an horizontal view
 */
class ComicsRecyclerViewAdapter :
    PagingDataAdapter<HeroComics, ComicsRecyclerViewAdapter.ViewHolder>(
        ComicsDiffer
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemComicsBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    class ViewHolder(private val binding: ItemComicsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(comics: HeroComics) {
            binding.comics = comics
            binding.executePendingBindings()
        }
    }

    companion object ComicsDiffer : DiffUtil.ItemCallback<HeroComics>() {
        override fun areItemsTheSame(
            oldItem: HeroComics,
            newItem: HeroComics
        ): Boolean =
            oldItem.comicName == newItem.comicName

        override fun areContentsTheSame(
            oldItem: HeroComics,
            newItem: HeroComics
        ): Boolean = oldItem == newItem
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}