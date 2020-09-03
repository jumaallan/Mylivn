plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.ktlintPlugin)
}

android {

    compileSdkVersion(AndroidSDK.compile)
    buildToolsVersion("30.0.1")

    android.buildFeatures.dataBinding = true
    android.buildFeatures.viewBinding = true

    defaultConfig {
        applicationId = "com.mylivn"
        minSdkVersion(AndroidSDK.min)
        targetSdkVersion(AndroidSDK.target)
        versionCode = Versions.code
        versionName = Versions.name
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    dependencies {
        implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
        implementation(Libraries.kotlinStandardLibrary)
        implementation(Libraries.ktxCore)

        implementation(Libraries.appCompat)
        implementation(Libraries.constraintLayout)
        implementation(Libraries.materialComponents)

        testImplementation(TestLibraries.junit4)
        androidTestImplementation(TestLibraries.testRunner)
        androidTestImplementation(TestLibraries.espresso)
        androidTestImplementation(TestLibraries.annotation)
    }
}