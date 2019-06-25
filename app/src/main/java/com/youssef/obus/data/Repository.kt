package com.youssef.obus.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.youssef.obus.data.models.Busline
import com.youssef.obus.data.models.Checkpoint

class Repository : IRepository {

    override fun getCheckpoints(): LiveData<List<Checkpoint>> {
        val result = MutableLiveData<List<Checkpoint>>()
        val busLinesList: ArrayList<Checkpoint> = ArrayList<Checkpoint>()

        busLinesList.add(Checkpoint("1", "Heliopolis", Pair(1.0f, 5.3f)))
        busLinesList.add(Checkpoint("2", "Roxy", Pair(1.0f, 5.3f)))
        busLinesList.add(Checkpoint("3", "Maadi", Pair(1.0f, 5.3f)))

        result.value = busLinesList
        return result
    }


    override fun getBuslines(): LiveData<List<Busline>> {
        val result = MutableLiveData<List<Busline>>()
        val busLinesList: ArrayList<Busline> = ArrayList<Busline>()

        busLinesList.add(Busline("Smart - Heliopolis", "Hassan", emptyList()))
        busLinesList.add(Busline("Smart - Roxy", "Youssef", emptyList()))
        busLinesList.add(Busline("Smart - Maadi", "Ahmed", emptyList()))

        result.value = busLinesList
        return result
    }
}