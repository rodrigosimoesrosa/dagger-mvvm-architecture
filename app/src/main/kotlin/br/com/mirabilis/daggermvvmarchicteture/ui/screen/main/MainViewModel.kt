package br.com.mirabilis.daggermvvmarchicteture.ui.screen.main

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.mirabilis.daggermvvmarchicteture.base.model.BaseViewModel
import br.com.mirabilis.daggermvvmarchicteture.base.pattern.Event
import br.com.mirabilis.daggermvvmarchicteture.entity.ui.LoginAuthenticateState
import br.com.mirabilis.daggermvvmarchicteture.entity.ui.ViewState
import br.com.mirabilis.daggermvvmarchicteture.interactor.UserInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by rodrigosimoesrosa on 2019-06-03.
 * Copyright © 2019. All rights reserved.
 */
@Singleton
class MainViewModel @Inject constructor(val getUserInteractor: UserInteractor.Get,
                                        val logoutInteractor: UserInteractor.Logout) : BaseViewModel() {

    private val authenticated: MutableLiveData<Event<LoginAuthenticateState>> = MutableLiveData()
    val isAuthenticated: LiveData<Event<LoginAuthenticateState>> = authenticated

    private val error: MutableLiveData<Event<Throwable>> = MutableLiveData()
    fun getError(): LiveData<Event<Throwable>> = error

    private val username: MutableLiveData<String> = MutableLiveData()
    fun getUsername(): LiveData<String> = username

    private val state: MutableLiveData<ViewState> = MutableLiveData()
    fun isState(): LiveData<ViewState> = state

    val retryClickListener = View.OnClickListener { checkUser() }

    init {
        defaultState()
    }

    private fun defaultState() {
        username.value = ""
        error.value = null
        state.value = ViewState.DEFAULT
    }

    fun checkUser() {
        state.value = ViewState.LOADING

        addDisposable(getUserInteractor
            .getUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                username.value = it.name
                state.value = ViewState.LOGGED
                error.value = null
            }, {
                authenticated.value = Event(LoginAuthenticateState.UNAUTHENTICATED)
            }))
    }

    fun logout() {
        state.value = ViewState.LOADING

        addDisposable(logoutInteractor
            .logout()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                authenticated.value = Event(LoginAuthenticateState.UNAUTHENTICATED)
            }, {
                error.value = Event(it)
                defaultState()
            }))
    }

    override fun onCleared() {
        defaultState()
        super.onCleared()
    }
}