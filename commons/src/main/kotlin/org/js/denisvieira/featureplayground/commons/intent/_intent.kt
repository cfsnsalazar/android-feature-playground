package org.js.denisvieira.featureplayground.commons.intent

import android.content.Intent

@Suppress("UNCHECKED_CAST")
fun <T> Intent.requireExtraValue(key: String): T {
    val extras = extras ?: error("Intent $this does not have any extras")
    return extras.get(key) as T ?: error("Intent $this does not have `$key` extra.")
}
