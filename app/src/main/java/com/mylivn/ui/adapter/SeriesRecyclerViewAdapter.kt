package com.mylivn.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mylivn.data.models.HeroSeries
import com.mylivn.databinding.ItemSeriesBinding

/**
 * SeriesRecyclerViewAdapter
 *
 * This adapter is responsible for setting the series list, as an horizontal view
 */
class SeriesRecyclerViewAdapter :
    PagingDataAdapter<HeroSeries, SeriesRecyclerViewAdapter.ViewHolder>(
        SeriesDiffer
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSeriesBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    class ViewHolder(private val binding: ItemSeriesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(series: HeroSeries) {
            binding.series = series
            binding.imgSeries.load(series.resourceURI)
            binding.executePendingBindings()

        }
    }

    companion object SeriesDiffer : DiffUtil.ItemCallback<HeroSeries>() {
        override fun areItemsTheSame(
            oldItem: HeroSeries,
            newItem: HeroSeries
        ): Boolean =
            oldItem.seriesName == newItem.seriesName

        override fun areContentsTheSame(
            oldItem: HeroSeries,
            newItem: HeroSeries
        ): Boolean = oldItem == newItem
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}