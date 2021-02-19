package com.example.vkfriends.activites

import android.os.Bundle
import androidx.core.view.isVisible
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.vkfriends.databinding.ActivityFriendsBinding
import com.example.vkfriends.models.FriendModel
import com.example.vkfriends.presenters.FriendsPresenter
import com.example.vkfriends.views.FriendsView

class FriendsActivity : MvpAppCompatActivity(), FriendsView {

    private var _binding: ActivityFriendsBinding? = null

    private val binding get() = _binding!!

    @InjectPresenter
    lateinit var friendsPresenter: FriendsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityFriendsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        friendsPresenter.loadFriends()
    }

    override fun startLoading() {
        binding.friendsError.isVisible = true
        binding.friendsRecyclerView.isVisible=false
        binding.friendsError.isVisible=false
    }

    override fun endLoading() {
        binding.friendsError.isVisible = false
    }

    override fun showError(text: Int) {
        binding.friendsError.text = resources.getText(text)
    }


    override fun setupEmptyList() {
        binding.friendsRecyclerView.isVisible = false
        binding.friendsError.isVisible = true
    }

    override fun setupFriendsList(friendsList: ArrayList<FriendModel>) {
        binding.friendsRecyclerView.isVisible = true
        binding.friendsError.isVisible = false
    }
}