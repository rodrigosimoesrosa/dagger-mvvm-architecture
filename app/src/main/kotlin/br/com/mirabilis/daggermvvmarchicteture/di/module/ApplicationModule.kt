package br.com.mirabilis.daggermvvmarchicteture.di.module

import android.app.Application
import br.com.mirabilis.daggermvvmarchicteture.MyApplication
import br.com.mirabilis.daggermvvmarchicteture.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by rodrigosimoesrosa on 2019-07-30.
 * Copyright © 2019. All rights reserved.
 */
@Module
class ApplicationModule(private val application: MyApplication) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return application
    }

}