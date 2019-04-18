package com.example.partiel_mobile_api.model

import android.os.Parcel
import android.os.Parcelable


class Movie(): Parcelable {
    lateinit var name: String
    lateinit var image: String

    constructor(name: String, image:String) : this() {
        this.name = name
        this.image = image
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(image)
    }


    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        image = parcel.readString()
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}