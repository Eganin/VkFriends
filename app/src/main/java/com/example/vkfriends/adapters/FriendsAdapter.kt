package com.example.vkfriends.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.vkfriends.R
import com.example.vkfriends.databinding.CellFriendBinding
import com.example.vkfriends.models.FriendModel

class FriendsAdapter : RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder>() {

    private var mFriendsList: ArrayList<FriendModel> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = FriendsViewHolder(
        itemBinding = CellFriendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: FriendsAdapter.FriendsViewHolder, position: Int) {
        holder.bind(model = mFriendsList[position])
    }

    override fun getItemCount() = mFriendsList.count()

    fun bindFriendsList(friendsList: ArrayList<FriendModel>) {
        mFriendsList.clear()
        mFriendsList.addAll(elements = friendsList)
        notifyDataSetChanged()
    }

    fun filter(text : String) {
        TODO("Not yet implemented")
    }

    inner class FriendsViewHolder(private val itemBinding: CellFriendBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        private val imageOptions =
            RequestOptions()
                .placeholder(R.drawable.ic_baseline_people_alt_24)
                .fallback(R.drawable.ic_baseline_people_alt_24)

        fun bind(model: FriendModel) {
            with(itemBinding) {
                loadImage(url = model.avatar ?: "")
                friendTxtUsername.text = "${model.name} ${model.surname}"
                friendTxtCity.text = model.city ?: "Unknown"
                friendImgOnline.isVisible = model.isOnline
            }
        }

        private fun loadImage(url: String) {
            Glide.with(itemBinding.root)
                .load(url)
                .apply(imageOptions)
                .into(itemBinding.friendCityAvatar)
        }
    }
}