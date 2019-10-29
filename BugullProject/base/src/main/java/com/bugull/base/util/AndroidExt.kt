package com.bugull.base.util

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bugull.base.base.BaseApplication

val Context.activityManager: ActivityManager
    get() = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

fun dp2px(context: Context, value: Float): Int =
    (context.resources.displayMetrics.density * value + 0.5f).toInt()

fun px2dp(context: Context, value: Float): Int =
    (value * 1.0f / context.resources.displayMetrics.density * value + 0.5f).toInt()

/**
 * 判断当前Context是否运行在当前进程
 */
val Context.isRunningCurrentProcess: Boolean
    get() = this.run {
        val myPid = android.os.Process.myPid()
        activityManager.runningAppProcesses.forEach {
            return@run it.pid == myPid && this.packageName == it.processName
        }
        false
    }
