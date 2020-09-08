package com.mylivn.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mylivn.data.local.entities.Series
import com.mylivn.databinding.ItemSeriesBinding

/**
 * SeriesRecyclerViewAdapter
 *
 * This adapter is responsible for setting the series list, as an horizontal view
 */
class SeriesRecyclerViewAdapter :
    PagingDataAdapter<Series, SeriesRecyclerViewAdapter.ViewHolder>(
        SeriesDiffer
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSeriesBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    class ViewHolder(private val binding: ItemSeriesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(series: Series) {
            binding.series = series
            binding.executePendingBindings()
        }
    }

    companion object SeriesDiffer : DiffUtil.ItemCallback<Series>() {
        override fun areItemsTheSame(
            oldItem: Series,
            newItem: Series
        ): Boolean =
            oldItem.seriesName == newItem.seriesName

        override fun areContentsTheSame(
            oldItem: Series,
            newItem: Series
        ): Boolean = oldItem == newItem
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}