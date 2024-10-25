package com.wildan.newsappkmm.data.datasource.remote

import com.wildan.newsappkmm.core.helper.toResult
import com.wildan.newsappkmm.core.network.EndPoint.URL
import com.wildan.newsappkmm.data.model.response.Article
import com.wildan.newsappkmm.data.model.wrapper.RemoteResult
import io.ktor.client.HttpClient
import io.ktor.client.request.get


/*
 * Created by Wildan Nafian on 10/16/24.
 * Github https://github.com/Wildanafian
 * wildanafian8@gmail.com
 */

internal class TechCrunchNewsRemoteImpl(private val client: HttpClient) : TechCrunchNewsRemote {

    override suspend fun getLatestNews(): RemoteResult<List<Article>> {
        return try {
            when (val result = client.get(URL).toResult<List<Article>>()) {
                is RemoteResult.Success -> {
                    RemoteResult.Success(data = result.data.articles.orEmpty())
                }

                is RemoteResult.Error -> {
                    result
                }
            }
        } catch (e: Exception) {
            RemoteResult.Error(
                e.message ?: "Something went wrong! Please try again or contact support."
            )
        }
    }

}
