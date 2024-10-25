package com.wildan.newsappkmm.core.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


/*
 * Created by Wildan Nafian on 10/16/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

internal class KtorClient (private val ktorEngine: HttpClientEngine) {

    fun init(): HttpClient {
        return HttpClient(ktorEngine) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                    coerceInputValues = true
                })
            }

            install(DefaultRequest) {
                headers.append("Content-Type", "application/json")
            }

            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }

        }
    }

}
