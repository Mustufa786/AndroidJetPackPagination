package com.codixlab.pagintutorial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item.view.*

class UserAdapter : PagedListAdapter<Data, UserAdapter.UserViewHolder>(USER_COMPARATOR) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        val user = getItem(position)
        user?.let { holder.bind(it) }

    }


    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val imageView = view.user_avatar
        private val userName = view.user_name
        private val userEmail = view.user_email
        fun bind(user: Data) {
            userName.text = user.firstName + " " + user.lastName
            userEmail.text = user.email
            Glide.with(imageView.context)
                .load(user.avatar)
                .into(imageView)
        }

    }

    companion object {
        private val USER_COMPARATOR = object : DiffUtil.ItemCallback<Data>() {
            override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean =
                newItem.id == oldItem.id
        }
    }

}