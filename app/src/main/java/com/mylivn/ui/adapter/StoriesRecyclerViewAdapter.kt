package com.mylivn.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mylivn.data.local.entities.Stories
import com.mylivn.databinding.ItemStoriesBinding

/**
 * StoriesRecyclerViewAdapter
 *
 * This adapter is responsible for setting the stories list, as an horizontal view
 */
class StoriesRecyclerViewAdapter :
    PagingDataAdapter<Stories, StoriesRecyclerViewAdapter.ViewHolder>(
        StoriesDiffer
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemStoriesBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    class ViewHolder(private val binding: ItemStoriesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(stories: Stories) {
            binding.stories = stories
            binding.executePendingBindings()
        }
    }

    companion object StoriesDiffer : DiffUtil.ItemCallback<Stories>() {
        override fun areItemsTheSame(
            oldItem: Stories,
            newItem: Stories
        ): Boolean =
            oldItem.storyName == newItem.storyName

        override fun areContentsTheSame(
            oldItem: Stories,
            newItem: Stories
        ): Boolean = oldItem == newItem
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}