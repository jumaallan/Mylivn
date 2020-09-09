package com.mylivn.ui.views

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.paging.map
import com.mylivn.R
import com.mylivn.data.local.mappers.toModel
import com.mylivn.databinding.ActivityHeroBinding
import com.mylivn.ui.adapter.*
import com.mylivn.ui.viewmodels.*
import kotlinx.android.synthetic.main.activity_hero.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 *  Hero Activity which is the Launcher Activity
 */

class HeroActivity : BindingActivity<ActivityHeroBinding>() {

    private val marvelViewModel: MarvelViewModel by viewModel()
    private val heroViewModel: HeroViewModel by viewModel()
    private val comicsViewModel: ComicsViewModel by viewModel()
    private val eventsViewModel: EventsViewModel by viewModel()
    private val seriesViewModel: SeriesViewModel by viewModel()
    private val storiesViewModel: StoriesViewModel by viewModel()

    private val heroRecyclerViewAdapter = HeroRecyclerViewAdapter()
    private val comicsRecyclerViewAdapter = ComicsRecyclerViewAdapter()
    private val eventsRecyclerViewAdapter = EventsRecyclerViewAdapter()
    private val seriesRecyclerViewAdapter = SeriesRecyclerViewAdapter()
    private val storiesRecyclerViewAdapter = StoriesRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerViewHero.apply {
            adapter = heroRecyclerViewAdapter
        }

        recyclerViewHeroComics.apply {
            adapter = comicsRecyclerViewAdapter
        }

        recyclerViewHeroSeries.apply {
            adapter = seriesRecyclerViewAdapter
        }

        recyclerViewHeroStories.apply {
            adapter = storiesRecyclerViewAdapter
        }

        recyclerViewHeroEvents.apply {
            adapter = eventsRecyclerViewAdapter
        }

        fetchHeroes(1011334)
    }

    private fun fetchHeroes(heroId: Int) = lifecycleScope.launch {
        marvelViewModel.fetchCharacters()
        marvelViewModel.fetchMarvelHeroes()
            .collectLatest { heroRecyclerViewAdapter.submitData(it.map { hero -> hero.toModel() }) }
        comicsViewModel.getHeroComics(heroId)
            .collectLatest { comicsRecyclerViewAdapter.submitData(it.map { comics -> comics.toModel() }) }
        seriesViewModel.getHeroSeries(heroId)
            .collectLatest { seriesRecyclerViewAdapter.submitData(it.map { series -> series.toModel() }) }
        storiesViewModel.getHeroStories(heroId)
            .collectLatest { storiesRecyclerViewAdapter.submitData(it.map { stories -> stories.toModel() }) }
        eventsViewModel.getHeroEvents(heroId)
            .collectLatest { eventsRecyclerViewAdapter.submitData(it.map { events -> events.toModel() }) }
    }

    override val layoutResId: Int
        get() = R.layout.activity_hero
}