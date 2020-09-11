## Mylivn Interview Solution

👀  Writing Mylivn Interview Solution App using [Android Architecture Components](https://developer.android.com/topic/libraries/architecture/), in 100% Kotlin, using Android Jetpack Components. 

### Prerequisites 

Before every commit, make sure you run the following commands:

```shell script
./codeAnalysis
```

To check for dependency updates, run the following command:

```shell script
./gradlew dependencyUpdate
```

Refer to this [issue](https://github.com/gradle/gradle/issues/10248), if you get any issues running the lint commands on the terminal :rocket:

### Background

Create an Android App to display a feed similar to the feed we have in Mylivn application.

The feed is the entry point of our application where we operate data from plenty of channels and display them in a beautiful UI to the users.

According to our application, users see the feed immediately after logging in. We want to impress users with a relevant, beautiful and high-performing UI, therefore feed has to be sophisticated.

## Tech-stack

* Tech-stack
    * [Kotlin](https://kotlinlang.org/) - a cross-platform, statically typed, general-purpose programming language with type inference.
    * [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - perform background operations.
    * [Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html) - handle the stream of data asynchronously that executes sequentially.
    * [KOIN](https://insert-koin.io/) - a pragmatic lightweight dependency injection framework.
    * [Retrofit](https://square.github.io/retrofit/) - a type-safe REST client for Android.
    * [Jetpack](https://developer.android.com/jetpack)
        * [Room](https://developer.android.com/topic/libraries/architecture/room) - a persistence library provides an abstraction layer over SQLite.
        * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - is an observable data holder.
        * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform action when lifecycle state changes.
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way.
    * [Stetho](http://facebook.github.io/stetho/) - application debugging tool.
    * [Timber](https://github.com/JakeWharton/timber) - a highly extensible android logger.
    * [Leak Canary](https://github.com/square/leakcanary) - a memory leak detection library for Android.

* Architecture
    * MVVM - Model View View Model
* Tests
    * [Unit Tests](https://en.wikipedia.org/wiki/Unit_testing) ([JUnit](https://junit.org/junit4/))
    * [Mockito](https://github.com/mockito/mockito) + [Mockito-Kotlin](https://github.com/nhaarman/mockito-kotlin)
    * [Kluent](https://github.com/MarkusAmshove/Kluent)
    * [Kakao](https://github.com/agoda-com/Kakao)
* Gradle
    * [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html) - For reference purposes, here's an [article explaining the migration](https://medium.com/@evanschepsiror/migrating-to-kotlin-dsl-4ee0d6d5c977).
    * Plugins 
        * [Ktlint](https://github.com/JLLeitschuh/ktlint-gradle) - creates convenient tasks in your Gradle project that run ktlint checks or do code auto format.
        * [Detekt](https://github.com/detekt/detekt) - a static code analysis tool for the Kotlin programming language.
        * [Spotless](https://github.com/diffplug/spotless) - format java, groovy, markdown and license headers using gradle.
        * [Dokka](https://github.com/Kotlin/dokka) - a documentation engine for Kotlin, performing the same function as javadoc for Java.
        * [jacoco](https://github.com/jacoco/jacoco) - a Code Coverage Library
* CI/CD
    * Github Actions 
    
    
## Dependencies

All the dependencies (external libraries) are defined in the single place - Gradle `buildSrc` folder. This approach allows to easily manage dependencies and use the same dependency version across all modules. 

## Some notable issues

This sections mentions some of the issues that I have come across:

- Paging (Paging 3.0) - The Marvel API doesn't support pagination, and made it hard to use Paging to paginate network requests. Room also doesn't work with the paging 3.0 library well (No paging setup on this project submission)
 
- UI Tests fail on an Emulator running API 26 (Android 8), and are successful on an Emulator running API 29 (Android 10)

- dokka documentation task doesn't work when run from the top level Mylivn task

- The spotless plugin doesn't apply the license header, and the jacoco plugin doesn't work as expected. Need more research on how to set them up using gradle plugins

## License
```
MIT License

Copyright (c) 2020 Juma Allan

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and 
associated documentation files (the "Software"), to deal in the Software without restriction, including 
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to 
the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial 
portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN 
NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
WHETHER IN AN ACTION OF  TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE 
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```
