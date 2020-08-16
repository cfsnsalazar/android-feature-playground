package org.js.denisvieira.featureplayground.commons.navigation

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.attachNavController(navigator: NavigatorControl) {
    navigator.navController = findNavController()
}
