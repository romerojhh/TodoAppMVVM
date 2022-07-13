package com.example.todoappmvvm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * have to extend Application() in order to be able to inject
 * have to add (android:name=".TodoApp") into AndroidManifest.xml
 */
@HiltAndroidApp
class TodoApp: Application()