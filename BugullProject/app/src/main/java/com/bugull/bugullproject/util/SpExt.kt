package com.bugull.bugullproject.util

import com.bugull.base.util.Sp
import com.bugull.bugullproject.MyApplication

var sp_userinfo: String by Sp(MyApplication.INSTANCE, "userInfo", "")
var sp_token: String by Sp(MyApplication.INSTANCE, "token", "")

fun clearSp() {
    sp_userinfo = ""
    sp_token = ""
}
