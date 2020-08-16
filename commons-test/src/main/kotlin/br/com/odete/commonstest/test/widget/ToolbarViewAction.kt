package br.com.odete.commonstest.test.widget

import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import org.hamcrest.Matcher

object ToolbarViewAction {

    fun navigationClick() =
        object : ViewAction {
            override fun getDescription(): String {
                return "Click in toolbar navigation action"
            }

            override fun getConstraints(): Matcher<View> {
                return withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)
            }

            override fun perform(uiController: UiController, view: View) {
                view as Toolbar

                val contentDescription = "PerformNavigationMockHackForClickWhenGoogleCantDoIt"
                view.navigationContentDescription = contentDescription

                onView(ViewMatchers.withContentDescription(contentDescription)).perform(click())
            }
        }
}
