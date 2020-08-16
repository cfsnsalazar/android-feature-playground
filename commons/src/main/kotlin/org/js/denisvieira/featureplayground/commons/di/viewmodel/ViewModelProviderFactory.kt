package org.js.denisvieira.featureplayground.commons.di.viewmodel

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.util.LinkedList

object ViewModelProviderFactory {

    @VisibleForTesting
    var viewModel: LinkedList<ViewModel> = LinkedList()
}

fun <T : ViewModel> ViewModelProvider.customGet(clazz: Class<out T>): T {
    return if (ViewModelProviderFactory.viewModel.isEmpty()) get(clazz)
    else ViewModelProviderFactory.viewModel.pop() as T
}
