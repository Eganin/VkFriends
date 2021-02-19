package com.example.vkfriends.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.vkfriends.models.FriendModel

@StateStrategyType(value= AddToEndSingleStrategy::class)
interface FriendsView : MvpView {
    fun startLoading()

    fun endLoading()

    fun showError(text : Int)

    fun setupEmptyList()

    fun setupFriendsList(friendsList : ArrayList<FriendModel>)
}