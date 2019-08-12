package br.com.mirabilis.daggermvvmarchicteture.interactor

import br.com.mirabilis.daggermvvmarchicteture.base.interactor.Interactor
import br.com.mirabilis.daggermvvmarchicteture.entity.business.User
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by rodrigosimoesrosa on 2019-05-27.
 * Copyright © 2019. All rights reserved.
 */
object UserInteractor {

    interface Login : Interactor {
        fun login(username: String, password: String): Completable
    }

    interface Save : Interactor {
        fun saveUser(user: User): Completable
    }

    interface Get : Interactor {
        fun getUser(): Single<User>
    }

    interface Authenticate : Interactor {
        fun authenticate(username: String, password: String): Single<User>
    }

    interface Logout : Interactor {
        fun logout(): Completable
    }

    interface Delete : Interactor {
        fun deleteUser(): Completable
    }

}
