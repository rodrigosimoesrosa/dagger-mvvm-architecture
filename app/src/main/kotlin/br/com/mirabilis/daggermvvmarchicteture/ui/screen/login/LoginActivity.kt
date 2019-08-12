package br.com.mirabilis.daggermvvmarchicteture.ui.screen.login

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.mirabilis.daggermvvmarchicteture.R
import br.com.mirabilis.daggermvvmarchicteture.base.pattern.observeEvent
import br.com.mirabilis.daggermvvmarchicteture.base.ui.BaseActivity
import br.com.mirabilis.daggermvvmarchicteture.databinding.ActivityLoginBinding
import br.com.mirabilis.daggermvvmarchicteture.entity.ui.LoginAuthenticateState
import br.com.mirabilis.daggermvvmarchicteture.ui.screen.main.MainActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by rodrigosimoesrosa on 2019-07-30.
 * Copyright © 2019. All rights reserved.
 */
class LoginActivity : BaseActivity<LoginViewModel>() {

    override fun createViewModel(): LoginViewModel {
        return ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
    }

    override fun getLayout(): Int = R.layout.activity_login

    private lateinit var binding: ActivityLoginBinding
    private var snackBar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setObservers()
        setBinding()
        btnLogin.setOnClickListener { doLogin() }
    }

    private fun setBinding() {
        binding = DataBindingUtil.setContentView(this, getLayout())
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    private fun doLogin() {
        val username = editUsername.text.toString()
        val password = editPassword.text.toString()
        viewModel.login(username, password)
    }

    private fun setObservers() {
        viewModel.getUsernameErrorField().observeEvent(this@LoginActivity, { id ->
            val username = getString(R.string.username)
            editUsername.error = getString(id, username)
        })

        viewModel.getPasswordErrorField().observeEvent(this@LoginActivity, { id ->
            val password = getString(R.string.password)
            editPassword.error = getString(id, password)
        })

        viewModel.isAuthenticated.observeEvent(this@LoginActivity, { state ->
            if (state == LoginAuthenticateState.AUTHENTICATED) {
                val intent = Intent()
                intent.setClass(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        })

        viewModel.getError().observeEvent(this@LoginActivity, { error ->
            val message = error.message
            if (message.isNullOrEmpty()) {
                snackBar?.dismiss()
                return@observeEvent
            }

            snackBar = Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG)
            snackBar?.show()
        })

    }
}
