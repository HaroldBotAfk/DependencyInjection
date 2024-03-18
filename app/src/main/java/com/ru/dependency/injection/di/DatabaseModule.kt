package com.ru.dependency.injection.di

import android.app.Application
import androidx.room.Room
import com.ru.dependency.injection.data.db.AppDatabase
import com.ru.dependency.injection.data.db.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//  В случае если hilt не может сам создать классы-зависимости мы должны явно указать ему как это создавать.
//Делается это с помощью пометки класса аннотацией Module. А сами методы должны помечаться аннотацией Provides
//и желательно называться с приствкой provides.
@Module
@InstallIn(SingletonComponent::class)  //Установление ограничения видимости модуля
class DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(application: Application): AppDatabase {  //scoped метод
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            AppDatabase.DB_NAME
        )
            .build()
    }

    @Provides
    fun providesUserDao(db: AppDatabase): UserDao {  //unscoped метод
        return db.userDao()
    }
}