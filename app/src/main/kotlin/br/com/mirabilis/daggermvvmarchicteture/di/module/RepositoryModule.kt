package br.com.mirabilis.daggermvvmarchicteture.di.module

import br.com.mirabilis.daggermvvmarchicteture.repository.UserRepository
import br.com.mirabilis.daggermvvmarchicteture.repository.api.AuthenticateUserRepository
import br.com.mirabilis.daggermvvmarchicteture.repository.local.DeleteUserRepository
import br.com.mirabilis.daggermvvmarchicteture.repository.local.GetUserRepository
import br.com.mirabilis.daggermvvmarchicteture.repository.local.SaveUserRepository
import dagger.Binds
import dagger.Module

/**
 * Created by rodrigosimoesrosa on 2019-06-03.
 * Copyright © 2019. All rights reserved.
 */
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindGetUserRepository(repository: GetUserRepository): UserRepository.Get

    @Binds
    abstract fun bindAuthenticateUserRepository(repository: AuthenticateUserRepository): UserRepository.Authenticate

    @Binds
    abstract fun bindSaveUserRepository(repository: SaveUserRepository): UserRepository.Save

    @Binds
    abstract fun bindDeleteUserRepository(repository: DeleteUserRepository): UserRepository.Delete

}
