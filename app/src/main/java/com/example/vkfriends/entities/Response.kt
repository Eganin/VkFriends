package com.example.vkfriends.entities

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class Response (
    @SerializedName("response")
    @Expose
    var response: Response_? = null
)