package br.com.mirabilis.daggermvvmarchicteture.interactor

import br.com.mirabilis.daggermvvmarchicteture.repository.UserRepository
import io.reactivex.Completable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by rodrigosimoesrosa on 2019-05-27.
 * Copyright © 2019. All rights reserved.
 */
@Singleton
class DeleteUserInteractor @Inject constructor(): UserInteractor.Delete {

    @Inject lateinit var repository: UserRepository.Delete

    override fun deleteUser(): Completable {
        return repository.deleteUser()
    }

}
