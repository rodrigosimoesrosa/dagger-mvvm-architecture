package br.com.mirabilis.daggermvvmarchicteture.ui.screen.main

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import br.com.mirabilis.daggermvvmarchicteture.R
import br.com.mirabilis.daggermvvmarchicteture.base.pattern.observeEvent
import br.com.mirabilis.daggermvvmarchicteture.base.ui.BaseActivity
import br.com.mirabilis.daggermvvmarchicteture.databinding.ActivityMainBinding
import br.com.mirabilis.daggermvvmarchicteture.entity.ui.LoginAuthenticateState
import br.com.mirabilis.daggermvvmarchicteture.ui.screen.login.LoginActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by rodrigosimoesrosa on 2019-07-30.
 * Copyright © 2019. All rights reserved.
 */
class MainActivity : BaseActivity<MainViewModel>() {

    override fun createViewModel(): MainViewModel {
        return ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

    override fun getLayout(): Int = R.layout.activity_main

    private lateinit var binding: ActivityMainBinding
    private var snackBar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setObservers()
        setBinding()
        btnLogout.setOnClickListener { viewModel.logout() }
    }

    override fun onResume() {
        super.onResume()
        viewModel.checkUser()
    }

    private fun setBinding() {
        binding = DataBindingUtil.setContentView(this@MainActivity, getLayout())
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    private fun setObservers() {
        viewModel.isAuthenticated.observeEvent(this@MainActivity, { state ->
            if (state == LoginAuthenticateState.UNAUTHENTICATED) {
                val intent = Intent()
                intent.setClass(this@MainActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        })

        viewModel.getError().observeEvent(this@MainActivity, { error ->
            val message = error.message
            if (message.isNullOrEmpty()) {
                snackBar?.dismiss()
                return@observeEvent
            }

            snackBar = Snackbar.make(binding.root, message, Snackbar.LENGTH_INDEFINITE)
            snackBar?.setAction(R.string.retry, viewModel.retryClickListener)
            snackBar?.show()
        })
    }
}
