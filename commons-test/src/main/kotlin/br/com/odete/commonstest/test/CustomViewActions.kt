package br.com.odete.commonstest.test

import android.view.View
import androidx.core.widget.NestedScrollView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ScrollToAction
import androidx.test.espresso.action.ViewActions.actionWithAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import com.google.android.material.appbar.AppBarLayout
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anyOf

class CustomViewActions {
    companion object {
        fun scrollTo(): ViewAction = actionWithAssertions(NestedScrollToAction())

        fun collapseAppBarLayout(): ViewAction = CollapseAppBarLayoutAction()
    }

    class NestedScrollToAction : ViewAction {
        private val scrollToAction = ScrollToAction()

        override fun getDescription(): String = "nested scroll to"

        override fun getConstraints(): Matcher<View> =
            anyOf(
                allOf(
                    withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE),
                    isDescendantOfA(isAssignableFrom(NestedScrollView::class.java))
                ),
                scrollToAction.constraints
            )

        override fun perform(uiController: UiController?, view: View?) {
            scrollToAction.perform(uiController, view)
        }
    }

    class CollapseAppBarLayoutAction : ViewAction {
        override fun getDescription(): String = "collapse app bar layout"

        override fun getConstraints(): Matcher<View> =
            isAssignableFrom(AppBarLayout::class.java)

        override fun perform(uiController: UiController, view: View) {
            (view as AppBarLayout).setExpanded(false)
            uiController.loopMainThreadUntilIdle()
        }
    }
}
