package com.mylivn.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mylivn.core.utils.toHttps
import com.mylivn.data.models.MarvelHero
import com.mylivn.databinding.ItemHeroBinding

/**
 * HeroRecyclerViewAdapter
 *
 * This adapter is responsible for setting the heroes list on the hero list at the top
 */
typealias ClickListener = (MarvelHero) -> Unit

class HeroRecyclerViewAdapter(private val clickListener: ClickListener) :
    ListAdapter<MarvelHero, HeroRecyclerViewAdapter.ViewHolder>(
        HeroesDiffer
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHeroBinding.inflate(inflater)
        return ViewHolder(binding, clickListener)
    }

    class ViewHolder(
        private val binding: ItemHeroBinding,
        private val clickListener: ClickListener
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(hero: MarvelHero) {
            binding.hero = hero
            binding.imageViewHeroAvatar.load(hero.heroThumbnail.toHttps())
            binding.executePendingBindings()
            binding.root.setOnClickListener {
                clickListener(hero)
            }
        }
    }

    companion object HeroesDiffer : DiffUtil.ItemCallback<MarvelHero>() {
        override fun areItemsTheSame(
            oldItem: MarvelHero,
            newItem: MarvelHero
        ): Boolean =
            oldItem.heroName == newItem.heroName

        override fun areContentsTheSame(
            oldItem: MarvelHero,
            newItem: MarvelHero
        ): Boolean = oldItem == newItem
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}