package com.youssef.obus.data

import android.arch.lifecycle.LiveData
import com.youssef.obus.data.models.Busline
import com.youssef.obus.data.models.Checkpoint

interface IRepository {
    fun getCheckpoints(): LiveData<List<Checkpoint>>
    fun getBuslines(): LiveData<List<Busline>>

}