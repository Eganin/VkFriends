package com.example.vkfriends.activites

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.vkfriends.adapters.FriendsAdapter
import com.example.vkfriends.databinding.ActivityFriendsBinding
import com.example.vkfriends.models.FriendModel
import com.example.vkfriends.presenters.FriendsPresenter
import com.example.vkfriends.views.FriendsView



class FriendsActivity : MvpAppCompatActivity(), FriendsView {

    private var _binding: ActivityFriendsBinding? = null
    private val binding get() = _binding!!

    @InjectPresenter
    lateinit var friendsPresenter: FriendsPresenter

    private val adapter = FriendsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityFriendsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        friendsPresenter.loadFriends()
        initViews()
    }

    override fun startLoading() {
        binding.friendsError.isVisible = true
        binding.friendsRecyclerView.isVisible = false
        binding.friendsError.isVisible = false
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
        adapter.bindFriendsList(friendsList = friendsList)
    }

    private fun initViews() {
        initRecyclerView()
        binding.friendsSearch.addTextChangedListener {
            object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    adapter.filter(text = s.toString())
                }

                override fun afterTextChanged(s: Editable?) {

                }
            }
        }
    }

    private fun initRecyclerView() {
        binding.friendsRecyclerView.layoutManager = LinearLayoutManager(this@FriendsActivity)
        binding.friendsRecyclerView.adapter = adapter
        binding.friendsRecyclerView.setHasFixedSize(true)
    }
}