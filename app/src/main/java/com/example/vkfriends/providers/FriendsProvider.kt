package com.example.vkfriends.providers

import android.os.Handler
import com.example.vkfriends.models.FriendModel
import com.example.vkfriends.presenters.FriendsPresenter

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
}