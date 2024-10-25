package com.wildan.newsappkmm.core.network

import io.ktor.client.engine.darwin.Darwin

actual fun ktorEngine() = Darwin.create()