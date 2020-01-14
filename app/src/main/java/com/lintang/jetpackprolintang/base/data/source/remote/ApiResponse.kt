package com.lintang.jetpackprolintang.base.data.source.remote

import com.lintang.jetpackprolintang.base.data.source.remote.StatusResponse.*

class ApiResponse<T>(val status: StatusResponse, val body: T?, val msg: String?) {
    companion object {
        fun <T> success(body: T?): ApiResponse<T> {
            return ApiResponse(SUCCESS, body, null)
        }

        fun <T> empty(msg: String?, body: T?): ApiResponse<T> {
            return ApiResponse(EMPTY, body, msg)
        }

        fun <T> error(msg: String?, body: T?): ApiResponse<T> {
            return ApiResponse(ERROR, body, msg)
        }


    }
}