package com.ru.dependency.injection.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ru.dependency.injection.data.db.contracts.UsersContact

@Entity(tableName = UsersContact.TABLE_NAME)
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = UsersContact.Columns.ID)
    val id: Int,
    @ColumnInfo(name = UsersContact.Columns.NAME)
    val name: String,
    @ColumnInfo(name = UsersContact.Columns.DESCRIPTION)
    val description: String
)
