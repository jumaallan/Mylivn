package com.mylivn.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mylivn.R
import com.mylivn.data.models.HeroStories
import com.mylivn.databinding.ItemStoriesBinding

/**
 * StoriesRecyclerViewAdapter
 *
 * This adapter is responsible for setting the stories list, as an horizontal view
 */
class StoriesRecyclerViewAdapter :
    ListAdapter<HeroStories, StoriesRecyclerViewAdapter.ViewHolder>(
        StoriesDiffer
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemStoriesBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    class ViewHolder(private val binding: ItemStoriesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(stories: HeroStories) {
            binding.stories = stories
            binding.imageViewStoriesUrl.setImageResource(R.drawable.ic_mylivn_placeholder)
//            binding.imageViewStoriesUrl.load("https://www.eu-startups.com/wp-content/uploads/2019/12/mylivn_globe_1024-500x500.png")
            binding.executePendingBindings()
        }
    }

    companion object StoriesDiffer : DiffUtil.ItemCallback<HeroStories>() {
        override fun areItemsTheSame(
            oldItem: HeroStories,
            newItem: HeroStories
        ): Boolean =
            oldItem.storyName == newItem.storyName

        override fun areContentsTheSame(
            oldItem: HeroStories,
            newItem: HeroStories
        ): Boolean = oldItem == newItem
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}