package br.com.mirabilis.daggermvvmarchicteture.repository.api

import br.com.mirabilis.daggermvvmarchicteture.entity.business.User
import br.com.mirabilis.daggermvvmarchicteture.repository.UserRepository
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by rodrigosimoesrosa on 2019-06-03.
 * Copyright © 2019. All rights reserved.
 */
@Singleton
class AuthenticateUserRepository @Inject constructor() : UserRepository.Authenticate {

    override fun authenticate(username: String, password: String): Single<User> {
        return Single.just(User(username, "TOKEN")).delay(3, TimeUnit.SECONDS).map {
            when ((0..2).random()) {
                0,1 -> it
                else -> throw Exception("It was not possible to authenticate, please try again!")
            }
        }
    }

}
