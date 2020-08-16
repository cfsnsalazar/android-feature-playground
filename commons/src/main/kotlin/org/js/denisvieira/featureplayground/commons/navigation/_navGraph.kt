package org.js.denisvieira.featureplayground.commons.navigation

import androidx.navigation.NavGraph

fun NavGraph.hasStartDestination() =
    startDestination != 0
