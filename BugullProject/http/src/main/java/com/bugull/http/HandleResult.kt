package com.bugull.http

import com.bugull.http.base.BaseResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope

/**
 *  Create by @author wxd
 *  @time 2019/10/30  上午 11:10
 *  @describe  数据处理
 *  @param response:接口返回参数
 *  @param sucessBlock:成功处理代码块
 *  @param errorBlock:失败处理代码块
 */
suspend fun executeResponse(response: BaseResponse<Any>, successBlock: suspend CoroutineScope.() -> Unit,
                            errorBlock: suspend CoroutineScope.() -> Unit) {
    coroutineScope {
        if (!response.success) errorBlock()
        else successBlock()
    }
}