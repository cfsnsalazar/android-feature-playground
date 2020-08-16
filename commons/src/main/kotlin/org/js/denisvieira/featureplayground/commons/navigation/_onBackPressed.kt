package org.js.denisvieira.featureplayground.commons.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.closeFeatureActivityOnBack(
    navigationHostFragment: Fragment,
    action: () -> Unit
) {
    val currentFragment = navigationHostFragment.childFragmentManager.fragments.first()

    if (currentFragment is OnBackPressedCallback)
        currentFragment.handleOnBackPressed()
    else
        action()
}
