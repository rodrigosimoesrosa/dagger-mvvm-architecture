package br.com.mirabilis.daggermvvmarchicteture.ui.screen.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.mirabilis.daggermvvmarchicteture.R
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
class LoginViewModel @Inject constructor(val loginInteractor: UserInteractor.Login) : BaseViewModel() {

    private val usernameErrorField: MutableLiveData<Event<Int>> = MutableLiveData()
    fun getUsernameErrorField(): LiveData<Event<Int>> = usernameErrorField

    private val passwordErrorField: MutableLiveData<Event<Int>> = MutableLiveData()
    fun getPasswordErrorField(): LiveData<Event<Int>> = passwordErrorField

    private val state: MutableLiveData<ViewState> = MutableLiveData()
    val isState: LiveData<ViewState> = state

    private val error: MutableLiveData<Event<Throwable>> = MutableLiveData()
    fun getError(): LiveData<Event<Throwable>> = error

    private val authenticated: MutableLiveData<Event<LoginAuthenticateState>> = MutableLiveData()
    val isAuthenticated: LiveData<Event<LoginAuthenticateState>> = authenticated

    init {
        defaultState()
    }

    private fun defaultState() {
        usernameErrorField.value = null
        passwordErrorField.value = null
        error.value = null
        state.value = ViewState.DEFAULT
    }

    fun login(username: String, password: String) {
        if (username.isEmpty()) {
            usernameErrorField.value = Event(R.string.empty_field)
            return
        }

        if (password.isEmpty()) {
            passwordErrorField.value = Event(R.string.empty_field)
            return
        }

        state.value = ViewState.LOADING

        addDisposable(loginInteractor.login(username, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                authenticated.value = Event(LoginAuthenticateState.AUTHENTICATED)
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