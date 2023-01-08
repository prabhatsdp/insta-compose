package dev.prabhatpandey.instacompose.core

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import dev.prabhatpandey.instacompose.BuildConfig
import dev.prabhatpandey.instacompose.core.utils.logging.PxDebugLogger
import dev.prabhatpandey.instacompose.core.utils.logging.PxReleaseLogger
import timber.log.Timber

@HiltAndroidApp
class InstaComposeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        configureTimberForLogging()
    }


    private fun configureTimberForLogging() {
        if (BuildConfig.DEBUG) Timber.plant(PxDebugLogger()) else Timber.plant(PxReleaseLogger())
    }
}