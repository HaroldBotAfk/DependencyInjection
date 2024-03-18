package com.ru.dependency.injection.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp  //Генерирует комнонент дагера для приложения
class App : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}