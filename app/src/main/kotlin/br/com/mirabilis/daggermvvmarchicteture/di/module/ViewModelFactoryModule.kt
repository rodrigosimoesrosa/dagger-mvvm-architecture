package br.com.mirabilis.daggermvvmarchicteture.di.module

import androidx.lifecycle.ViewModelProvider
import br.com.mirabilis.daggermvvmarchicteture.di.factory.ViewModelFactory
import dagger.Binds
import dagger.Module

/**
 * Created by rodrigosimoesrosa on 2019-06-03.
 * Copyright © 2019. All rights reserved.
 */
@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}
