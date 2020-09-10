package com.mylivn.ui.views

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.paging.map
import com.mylivn.R
import com.mylivn.core.network.NetworkResult
import com.mylivn.core.utils.toast
import com.mylivn.data.local.entities.Hero
import com.mylivn.data.local.mappers.toModel
import com.mylivn.data.models.MarvelHero
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


    private val comicsRecyclerViewAdapter = ComicsRecyclerViewAdapter()
    private val eventsRecyclerViewAdapter = EventsRecyclerViewAdapter()
    private val seriesRecyclerViewAdapter = SeriesRecyclerViewAdapter()
    private val storiesRecyclerViewAdapter = StoriesRecyclerViewAdapter()
    private lateinit var heroRecyclerViewAdapter: HeroRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fetchHeroes()
        heroRecyclerViewAdapter = HeroRecyclerViewAdapter {
            toast(it.heroName)
            fetchHeroDetails(it.heroId)

        }


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

        marvelViewModel.marvelResponse.observe(this) { heroesResponse ->
            when (heroesResponse) {
                is NetworkResult.Success -> {
                    binding.lottieLoadingAnimation.visibility = View.GONE
                    binding.mainView.visibility = View.VISIBLE
                }
                is NetworkResult.NetworkError -> {
                    binding.lottieLoadingAnimation.visibility = View.GONE
                }
                is NetworkResult.ServerError -> {
                    binding.lottieLoadingAnimation.visibility = View.GONE
                }
            }
        }
    }

    private fun fetchHeroes() {
        lifecycleScope.launch {
            if (marvelViewModel.areItemsPresent()) {
                marvelViewModel.fetchMarvelHeroes().observe(this@HeroActivity) {
                    lifecycleScope.launch {
                        heroRecyclerViewAdapter.submitData(it.map { hero: Hero -> hero.toModel() })
                    }
                }
            } else {
                binding.lottieLoadingAnimation.visibility = View.VISIBLE
                binding.mainView.visibility = View.GONE
                marvelViewModel.fetchCharacters()
                marvelViewModel.fetchMarvelHeroes().observe(this@HeroActivity) {
                    lifecycleScope.launch {
                        heroRecyclerViewAdapter.submitData(it.map { hero: Hero -> hero.toModel() })
                    }
                }
            }
        }
    }

    private fun fetchHeroDetails(heroId: Int) {
        comicsViewModel.getHeroComics(heroId)
            .observe(this@HeroActivity) {
                lifecycleScope.launch {
                    comicsRecyclerViewAdapter.submitData(it.map { comics -> comics.toModel() })
                }
            }

        seriesViewModel.getHeroSeries(heroId)
            .observe(this@HeroActivity) {
                lifecycleScope.launch {
                    seriesRecyclerViewAdapter.submitData(it.map { series -> series.toModel() })
                }
            }

        storiesViewModel.getHeroStories(heroId)
            .observe(this@HeroActivity) {
                lifecycleScope.launch {
                    storiesRecyclerViewAdapter.submitData(it.map { stories -> stories.toModel() })
                }
            }
        eventsViewModel.getHeroEvents(heroId)
            .observe(this@HeroActivity) {
                lifecycleScope.launch {
                    eventsRecyclerViewAdapter.submitData(it.map { events -> events.toModel() })
                }
            }
    }

    override val layoutResId: Int
        get() = R.layout.activity_hero
}