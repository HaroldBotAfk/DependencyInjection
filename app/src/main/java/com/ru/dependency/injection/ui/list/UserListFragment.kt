package com.ru.dependency.injection.ui.list

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ru.dependency.injection.R
import com.ru.dependency.injection.databinding.FragmentUserListBinding
import com.ru.dependency.injection.ui.list.adapter.UserAdapter
import com.ru.dependency.injection.utils.AutoClearedValue
import com.ru.dependency.injection.utils.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint //Аннотация во фрагменте для использования hilt в этом самом фрагменте
class UserListFragment : Fragment(R.layout.fragment_user_list) {

    private val binding: FragmentUserListBinding by viewBinding(FragmentUserListBinding::bind)
    private val viewModel: UserListViewModel by viewModels()
    private var userAdapter: UserAdapter by AutoClearedValue()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        bindViewModel()

        Handler(Looper.getMainLooper()).post {
            viewModel.getUsers()
        }
    }

    private fun initList() {
        userAdapter = UserAdapter { userID ->
            viewModel.deleteUser(userID)
        }
        with(binding.userList) {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    private fun bindViewModel() {
        viewModel.followList.observe(viewLifecycleOwner) { newList ->
            userAdapter.items = newList
        }
        viewModel.toastError.observe(viewLifecycleOwner) { messageError ->
            toast(messageError)
        }

        binding.FAB.setOnClickListener {
            viewModel.insertUser()
        }
    }
}