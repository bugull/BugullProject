package com.bugull.http

import com.bugull.http.base.BaseRetrofitClient
import okhttp3.OkHttpClient


object RetrofitClient : BaseRetrofitClient() {

    val service by lazy { getService(ApiService::class.java, Constant.url) }

    override fun handleBuilder(builder: OkHttpClient.Builder) {}
}