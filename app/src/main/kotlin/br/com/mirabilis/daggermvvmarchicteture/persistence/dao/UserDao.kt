package br.com.mirabilis.daggermvvmarchicteture.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.mirabilis.daggermvvmarchicteture.entity.persistence.User
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by rodrigosimoesrosa on 2019-06-03.
 * Copyright © 2019. All rights reserved.
 */
@Dao
interface UserDao {

    @Query("SELECT * FROM ${User.Attributes.ENTITY} LIMIT 1")
    fun get(): Single<User>

    @Insert
    fun save(user: User): Completable

    @Query("DELETE FROM ${User.Attributes.ENTITY}")
    fun delete(): Completable

}
