package br.com.mirabilis.daggermvvmarchicteture.repository

import br.com.mirabilis.daggermvvmarchicteture.base.repository.Repository
import br.com.mirabilis.daggermvvmarchicteture.entity.business.User
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by rodrigosimoesrosa on 2019-06-03.
 * Copyright © 2019. All rights reserved.
 */
object UserRepository {

    interface Get : Repository {
        fun getUser(): Single<User>
    }

    interface Authenticate : Repository {
        fun authenticate(username: String, password: String): Single<User>
    }

    interface Save : Repository {
        fun saveUser(user: User): Completable
    }

    interface Delete : Repository {
        fun deleteUser(): Completable
    }
}
