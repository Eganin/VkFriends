package com.example.vkfriends.providers

import android.os.Handler
import android.util.Log
import com.example.vkfriends.entities.Response
import com.example.vkfriends.models.FriendModel
import com.example.vkfriends.presenters.FriendsPresenter
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback
import com.vk.api.sdk.exceptions.VKApiExecutionException

class FriendsProvider(var presenter: FriendsPresenter) {
    fun textLoadFriends(hasFriends: Boolean) {
        Handler().postDelayed({
            val list = ArrayList<FriendModel>()
            if (hasFriends) {
                list.add(
                    FriendModel(
                        name = "sers",
                        surname = "srser",
                        city = null,
                        avatar = "https://art-assorty.ru/wp-content/uploads/2019/08/258-1.jpg",
                        isOnline = true
                    )
                )
                list.add(
                    FriendModel(
                        name = "sers",
                        surname = "srser",
                        city = null,
                        avatar = "",
                        isOnline = true
                    )
                )
            } else {

            }

            presenter.friendsLoaded(friendsList = list)
        }, 500)
    }

    fun loadFriends() {
        VK.execute(VKUsersRequest(), object : VKApiCallback<Response> {
            override fun success(result: Response) {
                Log.d("AAA",result.toString())
                val friendList = ArrayList<FriendModel>()
                result.response?.items?.forEach { item ->
                    friendList.add(
                        element = FriendModel(
                            name = item.firstName.toString(),
                            surname = item.lastName.toString(),
                            city = item.city?.title,
                            avatar = item.photo,
                            isOnline = item.isOnline == 1
                        )
                    )
                }
                presenter.friendsLoaded(friendsList = friendList)
            }

            override fun fail(error: Exception) {
                Log.d("AAA", error.message.toString())
            }
        })
    }
}