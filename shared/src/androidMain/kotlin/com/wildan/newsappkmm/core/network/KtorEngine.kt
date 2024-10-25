package com.wildan.newsappkmm.core.network

import io.ktor.client.engine.android.Android

actual fun ktorEngine() = Android.create()