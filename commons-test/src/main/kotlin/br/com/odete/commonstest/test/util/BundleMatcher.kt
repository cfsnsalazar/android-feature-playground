package br.com.odete.commonstest.test.util

import android.os.Bundle

fun equalBundles(one: Bundle, two: Bundle): Boolean {
    if (one.size() != two.size())
        return false

    if (!one.keySet().containsAll(two.keySet()))
        return false

    for (key in one.keySet()) {
        val valueOne = one.get(key)
        val valueTwo = two.get(key)
        if (valueOne is Bundle && valueTwo is Bundle) {
            if (!equalBundles(valueOne, valueTwo)) return false
        } else if (valueOne != valueTwo) return false
    }

    return true
}
