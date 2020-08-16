package br.com.odete.commonstest.test.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.Kodein
import org.kodein.di.TT
import org.kodein.di.direct

class ViewModelFactoryTest(private val injector: Kodein) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return injector.direct.Instance(TT(modelClass))
    }
}
