package br.com.mirabilis.daggermvvmarchicteture.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.mirabilis.daggermvvmarchicteture.entity.persistence.User
import br.com.mirabilis.daggermvvmarchicteture.persistence.dao.UserDao
import javax.inject.Singleton

/**
 * Created by rodrigosimoesrosa on 2019-06-03.
 * Copyright © 2019. All rights reserved.
 */
@Database(entities = [User::class], version = 1, exportSchema = false)
@Singleton
abstract class MyDataBase : RoomDatabase() {

    abstract fun userDao(): UserDao

    object Values {
        const val DATABASE_NAME = "my_database.db"
    }

}
