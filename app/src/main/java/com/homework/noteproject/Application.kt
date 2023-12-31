package com.homework.noteproject

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Application  : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}