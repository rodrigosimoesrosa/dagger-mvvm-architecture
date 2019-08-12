package br.com.mirabilis.daggermvvmarchicteture.repository.local

import br.com.mirabilis.daggermvvmarchicteture.persistence.dao.UserDao
import br.com.mirabilis.daggermvvmarchicteture.repository.UserRepository
import io.reactivex.Completable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by rodrigosimoesrosa on 2019-06-03.
 * Copyright © 2019. All rights reserved.
 */
@Singleton
class DeleteUserRepository @Inject constructor() : UserRepository.Delete {

    @Inject lateinit var dao: UserDao

    override fun deleteUser(): Completable {
        return dao.delete()
    }

}
