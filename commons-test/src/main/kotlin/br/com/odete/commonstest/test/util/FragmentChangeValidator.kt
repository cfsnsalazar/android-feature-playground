package br.com.odete.commonstest.test.util

import androidx.appcompat.app.AppCompatActivity
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.assertTrue

object FragmentChangeValidator {

    fun <T> assertFragmentIsInBackstack(
        rule: ActivityTestRule<out AppCompatActivity>,
        target: Class<T>
    ) {
        doWait()
        assertTrue(rule.activity.supportFragmentManager.fragments.lastOrNull()?.javaClass == target)
    }
}
