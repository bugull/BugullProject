package com.bugull.base.base
import androidx.multidex.MultiDexApplication
import com.bugull.base.util.isRunningCurrentProcess

abstract class BaseApplication: MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        /* 多进程导致Application#onCreate()执行多次 */
        if (isRunningCurrentProcess) {
            initCurrentProcess()
        }
        init()
    }

    abstract fun init()

    /**
     * 当前进程初始化
     */
    abstract fun initCurrentProcess()

    companion object {
        lateinit var INSTANCE: BaseApplication
    }
}

