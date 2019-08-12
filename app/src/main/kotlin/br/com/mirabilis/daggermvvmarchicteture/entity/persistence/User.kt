package br.com.mirabilis.daggermvvmarchicteture.entity.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import br.com.mirabilis.daggermvvmarchicteture.persistence.entity.OrmEntity
import java.io.Serializable

/**
 * Created by rodrigosimoesrosa on 2019-06-03.
 * Copyright © 2019. All rights reserved.
 */
@Entity(tableName = User.Attributes.ENTITY)
data class User(@PrimaryKey(autoGenerate = true)
                @ColumnInfo(name = Attributes.ID)
                val id: Long? = Values.LONG,

                @ColumnInfo(name = Attributes.NAME)
                val name: String? = Values.STRING,

                @ColumnInfo(name = Attributes.TOKEN)
                val token: String? = Values.STRING) : Serializable,
    OrmEntity<br.com.mirabilis.daggermvvmarchicteture.entity.business.User> {

    @Ignore
    constructor() : this(Values.LONG, Values.STRING, Values.STRING)

    object Values {
        const val STRING = ""
        const val LONG = 0L
    }

    object Attributes {
        const val ENTITY = "User"

        const val ID = "id"
        const val NAME = "name"
        const val TOKEN = "token"
    }

    override fun toBusiness(): br.com.mirabilis.daggermvvmarchicteture.entity.business.User {
        return br.com.mirabilis.daggermvvmarchicteture.entity.business.User(
            name = name ?: Values.STRING,
            token = token ?: Values.STRING)
    }
}
