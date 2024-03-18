package com.ru.dependency.injection.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.ru.dependency.injection.data.models.User
import com.ru.dependency.injection.databinding.ItemUserBinding

class UserAdapterDelegate(
    private val onItemClick: (userID: Int) -> Unit
) : AbsListItemAdapterDelegate<User, User, UserAdapterDelegate.UserHolder>() {

    override fun isForViewType(item: User, items: MutableList<User>, position: Int): Boolean {
        return item is User
    }

    override fun onCreateViewHolder(parent: ViewGroup): UserHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(item: User, holder: UserHolder, payloads: MutableList<Any>) {
        holder.bind(item)
    }

    class UserHolder(
        private val binding: ItemUserBinding,
        val onItemClick: (userID: Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        private var currentUserID: Int? = null

        init {
            binding.root.setOnClickListener {
                currentUserID?.let {
                    onItemClick(currentUserID!!)
                }
            }
        }

        fun bind(user: User) {
            currentUserID = user.id

            binding.itemUserNameTextView.text = user.name
            binding.itemUserDescTextView.text = user.description
        }
    }
}