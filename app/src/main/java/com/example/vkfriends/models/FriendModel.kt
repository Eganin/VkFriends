package com.example.vkfriends.models

data class FriendModel(
    val name : String,
    val surname : String,
    val city : String?,
    val avatar : String?,
    val isOnline : Boolean
)