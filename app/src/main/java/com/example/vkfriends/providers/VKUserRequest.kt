package com.example.vkfriends.providers

import com.example.vkfriends.entities.Response
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.vk.api.sdk.requests.VKRequest
import org.json.JSONObject

class VKUsersRequest(uids: IntArray = intArrayOf()) : VKRequest<Response>("friends.get") {
    init {
        if (uids.isNotEmpty()) {
            addParam("user_ids", uids.joinToString(","))
        }
        addParam("fields", "photo_200")
    }

    override fun parse(r: JSONObject): Response {
        val jsonParser = JsonParser.parseString(r.toString())
        val model = Gson().fromJson(jsonParser, Response::class.java)
        return model
    }
}