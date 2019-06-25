package com.youssef.obus.ui.buslines

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.youssef.obus.data.IRepository
import com.youssef.obus.data.Repository
import com.youssef.obus.data.models.Busline

class BuslinesListingViewModel : ViewModel() {
    val repositiory: IRepository = Repository()

    fun getBuslines(): LiveData<List<Busline>> {
        return repositiory.getBuslines()
    }
}
