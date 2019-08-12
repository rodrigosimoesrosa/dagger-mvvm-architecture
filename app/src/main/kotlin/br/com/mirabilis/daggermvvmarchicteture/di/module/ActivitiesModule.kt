package br.com.mirabilis.daggermvvmarchicteture.di.module

import br.com.mirabilis.daggermvvmarchicteture.ui.screen.login.LoginActivity
import br.com.mirabilis.daggermvvmarchicteture.ui.screen.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by rodrigosimoesrosa on 2019-07-30.
 * Copyright © 2019. All rights reserved.
 */
@Module
interface ActivitiesModule {

    @ContributesAndroidInjector
    fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun contributeLoginActivity(): LoginActivity
}