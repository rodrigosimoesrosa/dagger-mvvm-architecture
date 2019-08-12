package br.com.mirabilis.daggermvvmarchicteture.interactor

import br.com.mirabilis.daggermvvmarchicteture.entity.business.User
import br.com.mirabilis.daggermvvmarchicteture.repository.UserRepository
import io.reactivex.Completable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by rodrigosimoesrosa on 2019-05-27.
 * Copyright © 2019. All rights reserved.
 */
@Singleton
class SaveUserInteractor @Inject constructor():
    UserInteractor.Save {

    @Inject lateinit var repository: UserRepository.Save

    override fun saveUser(user: User): Completable {
        return repository.saveUser(user)
    }

}
