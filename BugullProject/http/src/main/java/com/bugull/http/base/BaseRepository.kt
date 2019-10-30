package com.bugull.http.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope


/**
 *  Create by @author wxd
 *  @time 2019/9/25  上午 10:42
 *  @describe
 */
open class BaseRepository {

    suspend fun <T : Any> apiCall(call: suspend () -> BaseResponse<T>): BaseResponse<T> {
        return call.invoke()
    }

}