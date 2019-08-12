package br.com.mirabilis.daggermvvmarchicteture.base.ui

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import br.com.mirabilis.daggermvvmarchicteture.base.model.BaseViewModel
import br.com.mirabilis.daggermvvmarchicteture.di.factory.ViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * Created by rodrigosimoesrosa on 2019-07-30.
 * Copyright © 2019. All rights reserved.
 */
abstract class BaseActivity<VIEW_MODEL : BaseViewModel> : AppCompatActivity() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: VIEW_MODEL

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = createViewModel()
        setContentView(getLayout())

    }

    abstract fun createViewModel(): VIEW_MODEL

    @LayoutRes
    protected abstract fun getLayout(): Int

}
