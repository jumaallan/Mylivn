package com.mylivn.ui.views

import android.os.Bundle
import com.mylivn.R
import com.mylivn.core.network.NetworkResult
import com.mylivn.databinding.ActivityHeroBinding
import com.mylivn.ui.viewmodels.*
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        marvelViewModel.getHeroes()

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

    override val layoutResId: Int
        get() = R.layout.activity_hero
}