package org.js.denisvieira.featureplayground.commons.fragment

import androidx.fragment.app.Fragment

@Suppress("UNCHECKED_CAST")
fun <T> Fragment.requireArgValue(key: String): T =
    requireArguments().get(key) as T ?: error("Fragment $this does not have `$key` argument.")
