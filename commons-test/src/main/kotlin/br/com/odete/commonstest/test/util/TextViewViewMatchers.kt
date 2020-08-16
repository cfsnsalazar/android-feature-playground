package br.com.odete.commonstest.test.util

import android.view.View
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher

object TextViewViewMatchers {
    @JvmStatic
    fun withText(@StringRes resourceId: Int, vararg any: String): Matcher<View> {
        return object : BoundedMatcher<View, TextView>(
            TextView::class.java
        ) {

            override fun describeTo(description: Description) {}

            override fun matchesSafely(view: TextView): Boolean {
                return view.text == view.context.getString(resourceId, * any)
            }
        }
    }
}
