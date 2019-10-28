package com.bugull.http

import com.bugull.http.base.BaseResponse
import retrofit2.http.*

/**
 *  Create by @author wxd
 *  @time 2019/9/19  上午 10:42
 *  @describe
 */
interface ApiService {

    @POST("/api/handler/login")
    suspend fun login(@Query("account") account: String, @Query("password") passWord: String): BaseResponse<String>
}