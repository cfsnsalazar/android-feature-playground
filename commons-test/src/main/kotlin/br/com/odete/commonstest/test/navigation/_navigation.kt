package br.com.odete.commonstest.test.navigation

import android.os.Bundle
import androidx.annotation.StyleRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import br.com.odete.commonstest.R
import br.com.odete.commonstest.test.assertNavigationBundleIsEquals
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.verify

fun verifyBundleNavigation(navController: NavController, bundle: Bundle) {
    val argumentCaptor = argumentCaptor<Bundle>()

    verify(navController).navigate(
        any(),
        argumentCaptor.capture()
    )

    assertNavigationBundleIsEquals(bundle, argumentCaptor)
}

inline fun <reified F : Fragment> launchFragmentWithKodeinMock(
    fragmentArgs: Bundle? = null,
    @StyleRes themeResId: Int = R.style.Theme_AppCompat,
    fragment: Fragment
) = launchFragmentInContainer<F>(
    fragmentArgs = fragmentArgs,
    themeResId = themeResId,
    factory = KodeinMockFragmentFactory(fragment)
)
