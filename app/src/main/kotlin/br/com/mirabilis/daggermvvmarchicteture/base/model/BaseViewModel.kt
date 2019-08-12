package br.com.mirabilis.daggermvvmarchicteture.base.model

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by rodrigosimoesrosa on 2019-07-30.
 * Copyright © 2019. All rights reserved.
 */
abstract class BaseViewModel : ViewModel() {

    private var compositeDisposable: CompositeDisposable? = CompositeDisposable()

    protected fun addDisposable(disposable: Disposable) {
        compositeDisposable?.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable?.clear()
        compositeDisposable = null
    }

}
