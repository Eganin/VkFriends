package com.example.vkfriends.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.vkfriends.R
import com.example.vkfriends.models.FriendModel
import com.example.vkfriends.providers.FriendsProvider
import com.example.vkfriends.views.FriendsView

@InjectViewState
class FriendsPresenter : MvpPresenter<FriendsView>() {
    fun loadFriends() {
        viewState.startLoading()
        FriendsProvider(presenter = this@FriendsPresenter).textLoadFriends(hasFriends = true)
    }

    fun friendsLoaded(friendsList : ArrayList<FriendModel>){
        viewState.endLoading()
        if(friendsList.isEmpty()){
            viewState.setupEmptyList()
            viewState.showError(text= R.string.no_items)
        }else{
            viewState.setupFriendsList(friendsList=friendsList)
        }
    }
}