package br.com.mirabilis.daggermvvmarchicteture.base.pattern

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * https://medium.com/androiddevelopers/livedata-with-snackbar-navigation-and-other-events-the-singleliveevent-case-ac2622673150
 * Used as a wrapper for data that is exposed via a LiveData that represents an event.
 */
open class Event<out TYPE>(private val value: TYPE) {

    var hasBeenHandled = false
        private set // Allow external read but not write

    /**
     * Returns the value and prevents its use again.
     */
    fun getValueIfNotHandled(): TYPE? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            value
        }
    }

    /**
     * Returns the value, even if it's already been handled.
     */
    fun peekValue(): TYPE = value
}

inline fun <TYPE> LiveData<Event<TYPE>>.observeEvent(owner: LifecycleOwner,
                                                     crossinline onEventUnhandledContent: (TYPE) -> Unit) {
    observe(owner, Observer { it?.getValueIfNotHandled()?.let(onEventUnhandledContent) })
}
