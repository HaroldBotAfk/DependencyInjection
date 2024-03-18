package com.ru.dependency.injection.ui.menu

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ru.dependency.injection.R
import com.ru.dependency.injection.databinding.FragmentMenuBinding

class MenuFragment : Fragment(R.layout.fragment_menu) {

    private val binding: FragmentMenuBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.userListButton.setOnClickListener {
            findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToUserListFragment())
        }
    }
}