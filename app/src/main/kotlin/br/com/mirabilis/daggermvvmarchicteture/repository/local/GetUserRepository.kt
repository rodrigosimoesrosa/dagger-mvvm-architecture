package br.com.mirabilis.daggermvvmarchicteture.repository.local

import br.com.mirabilis.daggermvvmarchicteture.entity.business.User
import br.com.mirabilis.daggermvvmarchicteture.persistence.dao.UserDao
import br.com.mirabilis.daggermvvmarchicteture.repository.UserRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by rodrigosimoesrosa on 2019-06-03.
 * Copyright © 2019. All rights reserved.
 */
@Singleton
class GetUserRepository @Inject constructor() : UserRepository.Get {

    @Inject lateinit var dao: UserDao

    override fun getUser(): Single<User> {
        return dao.get().map { it.toBusiness() }
    }

}
