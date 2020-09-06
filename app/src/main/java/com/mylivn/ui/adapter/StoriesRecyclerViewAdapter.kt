package com.mylivn.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mylivn.data.local.entities.Stories
import com.mylivn.databinding.ItemStoriesBinding

/**
 * StoriesRecyclerViewAdapter
 *
 * This adapter is responsible for setting the stories list, as an horizontal view
 */
internal class StoriesRecyclerViewAdapter :
    ListAdapter<Stories, StoriesRecyclerViewAdapter.ViewHolder>(
        CharacterFilmsDiffer
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemStoriesBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemStoriesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(stories: Stories) {
            binding.stories = stories
            binding.executePendingBindings()
        }
    }

    companion object CharacterFilmsDiffer : DiffUtil.ItemCallback<Stories>() {
        override fun areItemsTheSame(
            oldItem: Stories,
            newItem: Stories
        ): Boolean =
            oldItem.heroName == newItem.heroName

        override fun areContentsTheSame(
            oldItem: Stories,
            newItem: Stories
        ): Boolean = oldItem == newItem
    }
}