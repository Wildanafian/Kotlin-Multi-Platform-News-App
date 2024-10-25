package com.wildan.newsappkmm.core.helper

import com.wildan.newsappkmm.data.model.response.BaseResponse
import com.wildan.newsappkmm.data.model.wrapper.RemoteResult
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

suspend inline fun <reified T : Any> HttpResponse.toResult(): RemoteResult<BaseResponse<T>> {
    return when (status.value) {
        200 -> RemoteResult.Success(body<BaseResponse<T>>())
        else -> {
            val message = body<BaseResponse<Nothing>>().message
            RemoteResult.Error(message)
        }
    }
}

suspend inline fun <reified T : Any> HttpResponse.getResultGeneral(): RemoteResult<T> {
    return when (status.value) {
        200 -> RemoteResult.Success(body())
        400 -> RemoteResult.Error("Check your credentials and try again!")
        401 -> RemoteResult.Error("Authorization Failed! Try Logging In again.")
        500, 503 -> RemoteResult.Error("Server Disruption! We are on fixing it.")
        504 -> RemoteResult.Error("Too much load at this time, try again later!")
        else -> RemoteResult.Error("Something went wrong! Please try again or contact support.")
    }
}