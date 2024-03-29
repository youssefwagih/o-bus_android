package com.youssef.obus.ui.buslines

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.youssef.obus.data.IRepository
import com.youssef.obus.data.Repository
import com.youssef.obus.data.models.Busline

class BuslineMapViewModel : ViewModel() {
    val repositiory: IRepository = Repository()

    fun getBuslines(): LiveData<List<Busline>> {
        return repositiory.getBuslines()
    }
}
