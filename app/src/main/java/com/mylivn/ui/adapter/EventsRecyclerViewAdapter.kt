package com.mylivn.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mylivn.R
import com.mylivn.data.models.HeroEvents
import com.mylivn.databinding.ItemEventsBinding

/**
 * EventsRecyclerViewAdapter
 *
 * This adapter is responsible for setting the events list, as an horizontal view
 */
class EventsRecyclerViewAdapter :
    ListAdapter<HeroEvents, EventsRecyclerViewAdapter.ViewHolder>(
        EventsDiffer
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemEventsBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    class ViewHolder(private val binding: ItemEventsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(events: HeroEvents) {
            binding.events = events
            binding.imageViewEventUrl.setImageResource(R.drawable.ic_mylivn_placeholder)
//            binding.imageViewEventUrl.load("https://www.eu-startups.com/wp-content/uploads/2019/12/mylivn_globe_1024-500x500.png")
            binding.executePendingBindings()
        }
    }

    companion object EventsDiffer : DiffUtil.ItemCallback<HeroEvents>() {
        override fun areItemsTheSame(
            oldItem: HeroEvents,
            newItem: HeroEvents
        ): Boolean =
            oldItem.eventName == newItem.eventName

        override fun areContentsTheSame(
            oldItem: HeroEvents,
            newItem: HeroEvents
        ): Boolean = oldItem == newItem
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}