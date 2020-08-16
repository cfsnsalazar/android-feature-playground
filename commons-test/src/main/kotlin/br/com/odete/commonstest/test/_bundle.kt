package br.com.odete.commonstest.test

import android.os.Bundle
import com.nhaarman.mockitokotlin2.KArgumentCaptor
import org.junit.Assert

fun Bundle.isEquals(bundle: Bundle): Boolean {
    if (this.size() != bundle.size())
        return false

    if (!keySet().containsAll(bundle.keySet()))
        return false

    for (key in keySet()) {
        val keyOne = get(key)
        val keyTwo = bundle[key]

        if (keyOne is Bundle && keyTwo is Bundle)
            keyOne.isEquals(keyTwo)
        if (keyOne != keyTwo)
            return false
    }

    return true
}

fun assertNavigationBundleIsEquals(expectedBundle: Bundle, targetBundle: KArgumentCaptor<Bundle>) {
    Assert.assertTrue(expectedBundle.isEquals(targetBundle.firstValue))
}
