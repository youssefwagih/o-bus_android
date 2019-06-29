package com.youssef.obus.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.maps.model.LatLng
import com.youssef.obus.data.models.Busline
import com.youssef.obus.data.models.Checkpoint

class Repository : IRepository {

    override fun getCheckpoints(): LiveData<List<Checkpoint>> {
        val result = MutableLiveData<List<Checkpoint>>()
        val busLinesList: ArrayList<Checkpoint> = ArrayList<Checkpoint>()

        busLinesList.add(Checkpoint("1", "Heliopolis", LatLng(1.0, 5.3)))
        busLinesList.add(Checkpoint("2", "Roxy", LatLng(1.0, 5.3)))
        busLinesList.add(Checkpoint("3", "Maadi", LatLng(1.0, 5.3)))

        result.value = busLinesList
        return result
    }


    override fun getBuslines(): LiveData<List<Busline>> {
        val result = MutableLiveData<List<Busline>>()
        val busLinesList: ArrayList<Busline> = ArrayList<Busline>()

        val busline1Checkpoints = listOf<Checkpoint>(
            Checkpoint("1", "سنترال سراى القبة", LatLng(30.097906, 31.307151)),
            Checkpoint("2", "ابن سندر 1", LatLng(30.090531, 31.302729)),
            Checkpoint("3", "ابن سندر 2", LatLng(30.088015, 31.301039)),
            Checkpoint("4", "الدمرداش", LatLng(30.076762, 31.277220))

        )
        busLinesList.add(Busline("Smart - Heliopolis", "Hassan", busline1Checkpoints))
        busLinesList.add(Busline("Smart - Roxy", "Youssef", emptyList()))
        busLinesList.add(Busline("Smart - Maadi", "Ahmed", emptyList()))

        result.value = busLinesList
        return result
    }
}