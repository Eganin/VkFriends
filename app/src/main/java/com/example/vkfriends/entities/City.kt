package com.example.vkfriends.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class City (
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("title")
    @Expose
    var title: String? = null
)