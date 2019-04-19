package com.example.partiel_mobile_api.model

import android.os.Parcel
import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/*

    [Class Movie]

    Model of each object Movie

    List of properties:
        - title: Title of the movie
        - posterUrl: poster's url of the movie
        - overview: Overview of the movie

*/

@JsonIgnoreProperties(ignoreUnknown = true)
class Movie(): Parcelable {

    @JsonProperty(value = "title")
    lateinit var title: String

    @JsonProperty(value = "posterUrl")
    lateinit var posterUrl: String

    @JsonProperty(value = "overview")
    lateinit var overview:String

    constructor(title:String, posterUrl:String, overview:String): this() {
        this.title = title
        this.posterUrl = posterUrl
        this.overview = overview
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(posterUrl)
        parcel.writeString(overview)
    }

    constructor(parcel: Parcel) : this() {
        title = parcel.readString()
        posterUrl = parcel.readString()
        overview = parcel.readString()
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