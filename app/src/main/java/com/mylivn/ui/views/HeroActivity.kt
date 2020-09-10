package com.mylivn.ui.views

import android.os.Bundle
import android.view.View
import com.mylivn.R
import com.mylivn.core.network.NetworkResult
import com.mylivn.core.utils.hide
import com.mylivn.core.utils.show
import com.mylivn.data.local.mappers.toModel
import com.mylivn.databinding.ActivityHeroBinding
import com.mylivn.ui.adapter.*
import com.mylivn.ui.viewmodels.*
import kotlinx.android.synthetic.main.activity_hero.*
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
        marvelViewModel.fetchMarvelHeroes().observe(this@HeroActivity) {
            if (it.isEmpty()) {
                binding.lottieLoadingAnimation.visibility = View.VISIBLE
                binding.mainView.visibility = View.GONE
                marvelViewModel.fetchCharacters()
            } else {
                heroRecyclerViewAdapter.submitList(it.map { hero -> hero.toModel() })
            }
        }
    }

    private fun fetchHeroDetails(heroId: Int) {

        heroViewModel.getHero(heroId)
            .observe(this@HeroActivity) {
                binding.hero = it.toModel()
            }

        comicsViewModel.getHeroComics(heroId)
            .observe(this@HeroActivity) {
                if (it.isEmpty()) {
                    emptyViewComics.show()
                    tvComicsLabel.hide()
                    recyclerViewHeroComics.hide()
                }
                comicsRecyclerViewAdapter.submitList(it.map { comics -> comics.toModel() })
            }

        seriesViewModel.getHeroSeries(heroId)
            .observe(this@HeroActivity) {
                if (it.isEmpty()) {
                    emptyViewSeries.show()
                    tvSeriesLabel.hide()
                    recyclerViewHeroSeries.hide()
                }
                seriesRecyclerViewAdapter.submitList(it.map { series -> series.toModel() })
            }

        storiesViewModel.getHeroStories(heroId)
            .observe(this@HeroActivity) {
                if (it.isEmpty()) {
                    emptyViewStories.show()
                    tvStoriesLabel.hide()
                    recyclerViewHeroStories.hide()
                }
                storiesRecyclerViewAdapter.submitList(it.map { stories -> stories.toModel() })
            }
        eventsViewModel.getHeroEvents(heroId)
            .observe(this@HeroActivity) {
                if (it.isEmpty()) {
                    emptyViewEvents.show()
                    tvEventsLabel.hide()
                    recyclerViewHeroEvents.hide()
                }
                eventsRecyclerViewAdapter.submitList(it.map { events -> events.toModel() })
            }
    }

    override val layoutResId: Int
        get() = R.layout.activity_hero
}