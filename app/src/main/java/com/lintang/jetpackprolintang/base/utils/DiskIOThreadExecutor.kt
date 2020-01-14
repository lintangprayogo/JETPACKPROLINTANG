package com.lintang.jetpackprolintang.base.utils

import java.util.concurrent.Executor
import java.util.concurrent.Executors

class DiskIOThreadExecutor() : Executor {
    val mDiskIO: Executor

    init {
        mDiskIO = Executors.newSingleThreadExecutor()

    }

    override fun execute(command: Runnable) {
        mDiskIO.execute(command)
    }
}