package com.mylivn.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mylivn.data.local.entities.Events
import com.mylivn.databinding.ItemEventsBinding

/**
 * EventsRecyclerViewAdapter
 *
 * This adapter is responsible for setting the events list, as an horizontal view
 */
internal class EventsRecyclerViewAdapter :
    ListAdapter<Events, EventsRecyclerViewAdapter.ViewHolder>(
        CharacterFilmsDiffer
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemEventsBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemEventsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(events: Events) {
            binding.events = events
            binding.executePendingBindings()
        }
    }

    companion object CharacterFilmsDiffer : DiffUtil.ItemCallback<Events>() {
        override fun areItemsTheSame(
            oldItem: Events,
            newItem: Events
        ): Boolean =
            oldItem.heroName == newItem.heroName

        override fun areContentsTheSame(
            oldItem: Events,
            newItem: Events
        ): Boolean = oldItem == newItem
    }
}