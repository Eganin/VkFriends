package com.example.vkfriends.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vkfriends.R
import com.example.vkfriends.models.FriendModel

class FriendsAdapter : RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder>() {

    private var mFriendsList : ArrayList<FriendModel> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = FriendsViewHolder(
        itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.cell_friend, parent, false)
    )

    override fun onBindViewHolder(holder: FriendsAdapter.FriendsViewHolder, position: Int) {
        holder.bind(model = mFriendsList[position])
    }

    override fun getItemCount()=mFriendsList.size

    inner class FriendsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model:FriendModel){

        }
    }
}