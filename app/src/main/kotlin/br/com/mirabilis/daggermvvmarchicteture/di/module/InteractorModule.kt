package br.com.mirabilis.daggermvvmarchicteture.di.module

import br.com.mirabilis.daggermvvmarchicteture.interactor.*
import dagger.Binds
import dagger.Module

/**
 * Created by rodrigosimoesrosa on 2019-07-30.
 * Copyright © 2019. All rights reserved.
 */
@Module
abstract class InteractorModule {

    @Binds
    abstract fun bindGetUserInteractor(interactor: GetUserInteractor): UserInteractor.Get

    @Binds
    abstract fun bindAuthenticateUserInteractor(interactor: AuthenticateUserInteractor): UserInteractor.Authenticate

    @Binds
    abstract fun bindSaveUserInteractor(interactor: SaveUserInteractor): UserInteractor.Save

    @Binds
    abstract fun bindDeleteUserInteractor(interactor: DeleteUserInteractor): UserInteractor.Delete

    @Binds
    abstract fun bindLoginInteractor(interactor: LoginInteractor): UserInteractor.Login

    @Binds
    abstract fun bindLogoutInteractor(interactor: LogoutInteractor): UserInteractor.Logout

}
