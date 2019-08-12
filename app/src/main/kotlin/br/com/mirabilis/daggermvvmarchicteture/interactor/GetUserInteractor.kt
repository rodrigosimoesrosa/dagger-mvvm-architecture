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
class GetUserInteractor @Inject constructor(): UserInteractor.Get {

    @Inject lateinit var repository: UserRepository.Get

    override fun getUser(): Single<User> {
        return repository.getUser()
    }
}
