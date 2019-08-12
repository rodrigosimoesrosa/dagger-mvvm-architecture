package br.com.mirabilis.daggermvvmarchicteture.interactor

import io.reactivex.Completable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by rodrigosimoesrosa on 2019-05-27.
 * Copyright © 2019. All rights reserved.
 */
@Singleton
class LoginInteractor @Inject constructor(): UserInteractor.Login {

    @Inject lateinit var authenticate: UserInteractor.Authenticate
    @Inject lateinit var save: UserInteractor.Save

    override fun login(username: String, password: String): Completable {
        return authenticate.authenticate(username, password).flatMapCompletable { save.saveUser(it) }
    }

}
