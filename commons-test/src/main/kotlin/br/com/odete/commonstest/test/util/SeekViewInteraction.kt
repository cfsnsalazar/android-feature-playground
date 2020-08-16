package br.com.odete.commonstest.test.util

import android.view.View
import android.widget.SeekBar
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

fun withProgress(progress: Int): ViewAction {
    return object : ViewAction {
        override fun perform(uiController: UiController, view: View) {
            (view as SeekBar).progress = progress
        }

        override fun getDescription(): String {
            return "Set a progress"
        }

        override fun getConstraints(): Matcher<View> {
            return ViewMatchers.isAssignableFrom(SeekBar::class.java)
        }
    }
}

fun withSecondaryProgress(progress: Int): ViewAction {
    return object : ViewAction {
        override fun perform(uiController: UiController, view: View) {
            (view as SeekBar).secondaryProgress = progress
        }

        override fun getDescription(): String {
            return "Set a progress"
        }

        override fun getConstraints(): Matcher<View> {
            return ViewMatchers.isAssignableFrom(SeekBar::class.java)
        }
    }
}
