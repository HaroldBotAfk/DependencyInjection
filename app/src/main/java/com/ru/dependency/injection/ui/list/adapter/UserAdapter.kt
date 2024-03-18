package com.ru.dependency.injection.ui.list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.ru.dependency.injection.data.models.User

class UserAdapter(
    onItemClick: (userID: Int) -> Unit
) : AsyncListDifferDelegationAdapter<User>(UserCallback()) {

    init {
        delegatesManager
            .addDelegate(UserAdapterDelegate(onItemClick))
    }

    class UserCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }
    }
}