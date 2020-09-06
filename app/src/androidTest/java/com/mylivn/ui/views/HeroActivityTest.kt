package com.mylivn.ui.views

import android.view.View
import androidx.preference.PreferenceManager
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView
import com.mylivn.R
import com.mylivn.repository.*
import com.mylivn.ui.viewmodels.*
import io.mockk.mockk
import org.hamcrest.Matcher
import org.junit.Before
import org.junit.runner.RunWith
import org.koin.core.inject
import org.koin.test.KoinTest
import org.koin.test.mock.declare

@LargeTest
@RunWith(AndroidJUnit4::class)
class HeroActivityTest : KoinTest {

    private val context =
        InstrumentationRegistry.getInstrumentation().targetContext.applicationContext
    private val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    private val themeViewModel: ThemeViewModel by inject()

    private val marvelRepository = mockk<MarvelRepository>()
    private val heroRepository = mockk<HeroRepository>()
    private val comicsRepository = mockk<ComicsRepository>()
    private val eventsRepository = mockk<EventsRepository>()
    private val seriesRepository = mockk<SeriesRepository>()
    private val storiesRepository = mockk<StoriesRepository>()

    @Before
    fun setup() {
        declare { mockk<ThemeViewModel>() }
        declare {
            MarvelViewModel(marvelRepository)
            HeroViewModel(heroRepository)
            ComicsViewModel(comicsRepository)
            EventsViewModel(eventsRepository)
            SeriesViewModel(seriesRepository)
            StoriesViewModel(storiesRepository)
        }
    }

}

class HeroScreen : Screen<HeroScreen>() {
    val heroesList = KRecyclerView(
        { withId(R.id.recyclerViewHero) },
        itemTypeBuilder = {
            itemType(::HeroesItem)
        }
    )

}

class HeroesItem(parent: Matcher<View>) : KRecyclerItem<HeroesItem>(parent) {
    val imageViewHeroAvatar: KImageView = KImageView(parent) { withId(R.id.imageViewHeroAvatar) }
    val textViewHeroName: KTextView = KTextView(parent) { withId(R.id.textViewHeroName) }
}