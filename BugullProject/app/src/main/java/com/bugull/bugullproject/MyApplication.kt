package com.bugull.bugullproject

import com.bugull.base.base.BaseApplication

class MyApplication :BaseApplication (){

    override fun init() {
        INSTANCE = this

    }

    override fun initCurrentProcess() {

    }

    companion object {
        lateinit var INSTANCE: BaseApplication
    }
}