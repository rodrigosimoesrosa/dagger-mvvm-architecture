package br.com.mirabilis.daggermvvmarchicteture.repository.local

import br.com.mirabilis.daggermvvmarchicteture.entity.business.User
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
class SaveUserRepository @Inject constructor() : UserRepository.Save {

    @Inject lateinit var dao: UserDao

    override fun saveUser(user: User): Completable {
        return dao.save(user.toPersistence())
    }

}
