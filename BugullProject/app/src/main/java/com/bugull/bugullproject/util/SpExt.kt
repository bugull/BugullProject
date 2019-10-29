package com.bugull.bugullproject.util

import com.bugull.base.util.Sp

var sp_userinfo: String by Sp("userInfo", "")
var sp_token: String by Sp("token", "")

fun clearSp() {
    sp_userinfo = ""
//        sp_token = ""
}
