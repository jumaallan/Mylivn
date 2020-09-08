package com.mylivn.ui.views

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.mylivn.R
import com.mylivn.core.network.NetworkResult
import com.mylivn.databinding.ActivityHeroBinding
import com.mylivn.ui.adapter.*
import com.mylivn.ui.viewmodels.*
import kotlinx.android.synthetic.main.activity_hero.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

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

        marvelViewModel.getHeroes()

        fetchHeroes(1)

        marvelViewModel.heroesResponseState.observe(
            this, {
                when (val heroesResponse = it.heroes) {
                    is NetworkResult.Success -> {
                        Timber.d("Jumaaaa")
                    }
                    is NetworkResult.ServerError -> {
                        Timber.d(heroesResponse.errorBody?.message ?: "A network error occurred")
                    }
                    is NetworkResult.NetworkError -> {
                        Timber.d("A network error occurred when making your request")
                    }
                }
            }
        )


    }

    private fun fetchHeroes(heroId: Int) {
        lifecycleScope.launch {
            comicsViewModel.getHeroComics(heroId).collectLatest {
                comicsRecyclerViewAdapter.submitData(it)
            }
            seriesViewModel.getHeroSeries(heroId).collectLatest {
                seriesRecyclerViewAdapter.submitData(it)
            }
            storiesViewModel.getHeroStories(heroId).collectLatest {
                storiesRecyclerViewAdapter.submitData(it)
            }
            eventsViewModel.getHeroEvents(heroId).collectLatest {
                eventsRecyclerViewAdapter.submitData(it)
            }
        }
    }

    override val layoutResId: Int
        get() = R.layout.activity_hero
}