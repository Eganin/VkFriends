package com.example.vkfriends.activites

import android.os.Bundle
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.vkfriends.R
import com.example.vkfriends.models.FriendModel
import com.example.vkfriends.presenters.FriendsPresenter
import com.example.vkfriends.views.FriendsView

class FriendsActivity : MvpAppCompatActivity(),FriendsView {

    @InjectPresenter
    lateinit var friendsPresenter: FriendsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)
    }

    override fun showError(text: String) =
        Toast.makeText(this@FriendsActivity, text, Toast.LENGTH_LONG).show()

    override fun setupEmptyList() {
        TODO("Not yet implemented")
    }

    override fun setupFriendsList(friendsList: ArrayList<FriendModel>) {
        TODO("Not yet implemented")
    }
}