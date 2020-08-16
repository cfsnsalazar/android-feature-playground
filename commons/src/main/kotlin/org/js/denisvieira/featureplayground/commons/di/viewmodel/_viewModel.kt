package org.js.denisvieira.featureplayground.commons.di.viewmodel

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import org.kodein.di.KodeinAware
import org.kodein.di.direct
import org.kodein.di.generic.instance

fun <VM : ViewModel, T> T.viewModel(clazz: Class<VM>): Lazy<VM> where T : KodeinAware, T : Fragment {
    return lazy { ViewModelProviders.of(this, direct.instance()).get(clazz) }
}

fun <VM : ViewModel, T> T.activityViewModel(clazz: Class<VM>): Lazy<VM> where T : KodeinAware, T : Fragment {
    return lazy { ViewModelProviders.of(requireActivity(), direct.instance()).get(clazz) }
}

fun <VM : ViewModel, T> T.viewModel(clazz: Class<VM>): Lazy<VM> where T : KodeinAware, T : FragmentActivity {
    return lazy { ViewModelProviders.of(this, direct.instance()).get(clazz) }
}
