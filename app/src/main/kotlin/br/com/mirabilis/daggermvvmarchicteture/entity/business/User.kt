package br.com.mirabilis.daggermvvmarchicteture.entity.business

import br.com.mirabilis.daggermvvmarchicteture.entity.persistence.User
import java.io.Serializable

/**
 * Created by rodrigosimoesrosa on 2019-05-27.
 * Copyright © 2019. All rights reserved.
 */
data class User(val name: String,
                val token: String): Serializable {

    fun toPersistence(): User {
        return User(name = name, token = token)
    }
}