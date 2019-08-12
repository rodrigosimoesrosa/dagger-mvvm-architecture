package br.com.mirabilis.daggermvvmarchicteture.interactor

import br.com.mirabilis.daggermvvmarchicteture.entity.business.User
import br.com.mirabilis.daggermvvmarchicteture.repository.UserRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by rodrigosimoesrosa on 2019-05-27.
 * Copyright © 2019. All rights reserved.
 */
@Singleton
class AuthenticateUserInteractor @Inject constructor(): UserInteractor.Authenticate {

    @Inject lateinit var repository: UserRepository.Authenticate

    override fun authenticate(username: String, password: String): Single<User> {
        return repository.authenticate(username, password)
    }

}
