package com.ru.dependency.injection.ui.menu

import androidx.lifecycle.ViewModel

class MenuViewModel : ViewModel() {

    private val repository = MenuRepository()
}