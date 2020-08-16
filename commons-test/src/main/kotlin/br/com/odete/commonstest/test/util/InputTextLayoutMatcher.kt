package br.com.odete.commonstest.test.util

import android.view.View
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

object InputTextLayoutMatcher {

    fun hasErrorText(text: String) =
        object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description?) {
            }

            override fun matchesSafely(item: View?): Boolean {
                if (item !is TextInputLayout) {
                    return false
                }

                return text == item.error
            }
        }
}
