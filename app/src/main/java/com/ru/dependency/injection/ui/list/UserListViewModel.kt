package com.ru.dependency.injection.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ru.dependency.injection.data.db.UserListRepository
import com.ru.dependency.injection.data.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//  Hilt требует аннотации Inject для создания классов с зависимостями. Далее он идет в репозиторий и требует уже
//Inject для репозитория и так далее по списку вызова зависимостей
@HiltViewModel  //Автоматическая генерация фабрики для создания ViewModel с конструктором
class UserListViewModel @Inject constructor(
    private val repository: UserListRepository  //инъекция в конструктор
) : ViewModel() {

    private val followListLiveData = MutableLiveData<List<User>>()
    private val toastErrorLiveData = MutableLiveData<String>()

    val followList: LiveData<List<User>>
        get() = followListLiveData

    val toastError: LiveData<String>
        get() = toastErrorLiveData

    fun getUsers() {
        try {
            viewModelScope.launch {
                followListLiveData.postValue(repository.getUsers())
            }
        } catch (e: Throwable) {
            toastErrorLiveData.postValue(e.message)
        }
    }

    fun insertUser() {
        try {
            viewModelScope.launch {
                val user = repository.createUser()
                repository.insertUser(user)
                getUsers()
            }
        } catch (e: Throwable) {
            toastErrorLiveData.postValue(e.message)
        }
    }

    fun deleteUser(userId: Int) {
        try {
            viewModelScope.launch {
                repository.deleteUser(userId)
                getUsers()
            }
        } catch (e: Throwable) {
            toastErrorLiveData.postValue(e.message)
        }
    }
}