package br.com.mirabilis.daggermvvmarchicteture.interactor

import io.reactivex.Completable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by rodrigosimoesrosa on 2019-05-27.
 * Copyright © 2019. All rights reserved.
 */
@Singleton
class LogoutInteractor @Inject constructor(): UserInteractor.Logout {

    @Inject lateinit var delete: UserInteractor.Delete

    override fun logout(): Completable {
        return delete.deleteUser()
    }

}
