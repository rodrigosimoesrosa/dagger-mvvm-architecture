package br.com.mirabilis.daggermvvmarchicteture.di.module

import androidx.lifecycle.ViewModel
import br.com.mirabilis.daggermvvmarchicteture.di.ViewModelKey
import br.com.mirabilis.daggermvvmarchicteture.ui.screen.login.LoginViewModel
import br.com.mirabilis.daggermvvmarchicteture.ui.screen.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by rodrigosimoesrosa on 2019-06-03.
 * Copyright © 2019. All rights reserved.
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    protected abstract fun mainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    protected abstract fun loginViewModel(mainViewModel: LoginViewModel): ViewModel

}
