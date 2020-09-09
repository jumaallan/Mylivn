package com.mylivn.data.local.mappers

import com.mylivn.data.local.entities.*
import com.mylivn.data.models.*

fun Hero.toModel(): MarvelHero =
    MarvelHero(
        heroName = this.heroName,
        heroDescription = this.heroDescription,
        heroThumbnail = this.heroThumbnail,
        heroId = this.heroId
    )

fun Comics.toModel(): HeroComics =
    HeroComics(
        comicName = this.comicName,
        resourceURI = this.resourceURI
    )

fun Series.toModel(): HeroSeries =
    HeroSeries(
        seriesName = this.seriesName,
        resourceURI = this.resourceURI
    )

fun Stories.toModel(): HeroStories =
    HeroStories(
        storyName = this.storyName,
        resourceURI = this.resourceURI,
        type = this.type
    )

fun Events.toModel(): HeroEvents =
    HeroEvents(
        eventName = this.eventName,
        resourceURI = this.resourceURI,
    )