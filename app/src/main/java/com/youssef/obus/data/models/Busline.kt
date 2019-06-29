package com.youssef.obus.data.models

import android.os.Parcel
import android.os.Parcelable

public data class Busline(var name: String, var driverName: String, val checkpoints: List<Checkpoint>) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.createTypedArrayList(Checkpoint)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(driverName)
        parcel.writeTypedList(checkpoints)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Busline> {
        override fun createFromParcel(parcel: Parcel): Busline {
            return Busline(parcel)
        }

        override fun newArray(size: Int): Array<Busline?> {
            return arrayOfNulls(size)
        }
    }

}