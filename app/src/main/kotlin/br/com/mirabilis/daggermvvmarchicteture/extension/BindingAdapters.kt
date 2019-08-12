package br.com.mirabilis.daggermvvmarchicteture.extension

import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import br.com.mirabilis.daggermvvmarchicteture.entity.ui.ViewState
import com.google.android.material.textfield.TextInputEditText

/**
 * Created by rodrigosimoesrosa on 2019-08-08.
 * Copyright © 2019. All rights reserved.
 */
@BindingAdapter("state")
fun setState(view: View, observable: LiveData<ViewState>?) {
    when (view) {
        is TextInputEditText -> {
            view.isEnabled = observable?.value.let {
                when (it) {
                    ViewState.DEFAULT -> true
                    ViewState.LOADING -> false
                    else -> true
                }
            }
        }

        is AppCompatButton -> {
            view.visibility = observable?.value.let {
                when (it) {
                    ViewState.DEFAULT -> View.VISIBLE
                    ViewState.LOADING -> View.GONE
                    ViewState.LOGGED -> View.VISIBLE
                    else -> View.VISIBLE
                }
            }
        }

        is ProgressBar -> {
            view.visibility = observable?.value.let {
                when (it) {
                    ViewState.DEFAULT -> View.GONE
                    ViewState.LOADING -> View.VISIBLE
                    else -> View.GONE
                }
            }
        }

        is AppCompatTextView -> {
            view.visibility = observable?.value.let {
                when (it) {
                    ViewState.DEFAULT -> View.GONE
                    ViewState.LOADING -> View.GONE
                    ViewState.LOGGED -> View.VISIBLE
                    else -> View.GONE
                }
            }
        }

    }
}
