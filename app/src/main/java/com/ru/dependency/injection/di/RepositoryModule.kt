package com.ru.dependency.injection.di

import com.ru.dependency.injection.data.db.UserListRepository
import com.ru.dependency.injection.ui.list.UserListRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {  //В случае с Binds и абстрактным классом и методом, то hilt сам поймет как связать эти 2 компонрента

    @Binds  //Когда кто-то попросил UserListRepository (интерфейс) мы говорим, чтобы hilt создал UserListRepositoryImpl (он уже это умеет т.к. на нем есть аннотация Inject) и вернуть нам эту имплементатию
    abstract fun providesUserRepository(impl: UserListRepositoryImpl): UserListRepository  //если захотим подменить репозиторий, то нужно лишь изменить тут вид имплементацию, и она поменяется во всех местах приложения
}