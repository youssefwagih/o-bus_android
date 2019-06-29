package com.youssef.obus.data.models

import android.os.Parcel
import android.os.Parcelable
import com.google.android.gms.maps.model.LatLng

data class Checkpoint(var id: String, var name: String, var latLang: LatLng) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(LatLng::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeParcelable(latLang, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Checkpoint> {
        override fun createFromParcel(parcel: Parcel): Checkpoint {
            return Checkpoint(parcel)
        }

        override fun newArray(size: Int): Array<Checkpoint?> {
            return arrayOfNulls(size)
        }
    }
}