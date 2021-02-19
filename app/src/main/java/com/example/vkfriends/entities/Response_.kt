package com.example.vkfriends.entities

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class Response_ (
    @SerializedName("count")
    @Expose
    var count: Int? = null,

    @SerializedName("items")
    @Expose
    var items: List<Item>? = null
)