package com.example.vkfriends.entities

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class Item(
    @SerializedName("first_name")
    @Expose
    var firstName: String? = null,

    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("last_name")
    @Expose
    var lastName: String? = null,

    @SerializedName("can_access_closed")
    @Expose
    var canAccessClosed: Boolean? = null,

    @SerializedName("is_closed")
    @Expose
    var isClosed: Boolean? = null,

    @SerializedName("domain")
    @Expose
    var domain: String? = null,

    @SerializedName("track_code")
    @Expose
    var trackCode: String? = null,

    @SerializedName("city")
    @Expose
    var city: City? = null,

    @SerializedName("photo_200")
    @Expose
    var photo: String? = null,

    @SerializedName("online")
    @Expose
    var isOnline: Int? = null
)