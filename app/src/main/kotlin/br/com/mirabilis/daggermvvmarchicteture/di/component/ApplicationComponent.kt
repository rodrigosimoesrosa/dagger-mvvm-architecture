package br.com.mirabilis.daggermvvmarchicteture.di.component

import android.app.Application
import br.com.mirabilis.daggermvvmarchicteture.MyApplication
import br.com.mirabilis.daggermvvmarchicteture.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by rodrigosimoesrosa on 2019-07-30.
 * Copyright © 2019. All rights reserved.
 */
@Component(modules = [
    DatabaseModule::class,
    RepositoryModule::class,
    InteractorModule::class,
    ActivitiesModule::class,
    ViewModelModule::class,
    AndroidSupportInjectionModule::class])
@Singleton
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }

    fun inject(appController: MyApplication)
}
