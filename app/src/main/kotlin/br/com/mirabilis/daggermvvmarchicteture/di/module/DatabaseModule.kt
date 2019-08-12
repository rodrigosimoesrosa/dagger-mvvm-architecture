package br.com.mirabilis.daggermvvmarchicteture.di.module

import android.app.Application
import androidx.room.Room
import br.com.mirabilis.daggermvvmarchicteture.persistence.MyDataBase
import br.com.mirabilis.daggermvvmarchicteture.persistence.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by rodrigosimoesrosa on 2019-07-30.
 * Copyright © 2019. All rights reserved.
 */
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): MyDataBase {
        return Room.databaseBuilder(application.applicationContext, MyDataBase::class.java,
            MyDataBase.Values.DATABASE_NAME).build()
    }

    @Provides
    @Singleton
    fun provideUserDAO(database: MyDataBase): UserDao {
        return database.userDao()
    }
}
