package br.com.mirabilis.daggermvvmarchicteture.persistence.entity

/**
 * Created by rodrigosimoesrosa on 2019-06-03.
 * Copyright © 2019. All rights reserved.
 */
interface OrmEntity<BUSINESS_ENTITY> {
    fun toBusiness(): BUSINESS_ENTITY
}
