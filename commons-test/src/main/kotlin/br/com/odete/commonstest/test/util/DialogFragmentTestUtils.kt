package br.com.odete.commonstest.test.util

import androidx.appcompat.app.AppCompatActivity
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import androidx.test.runner.lifecycle.Stage
import org.junit.Assert

object DialogFragmentTestUtils {

    /**
     * Verify if fragment with tag is visible to the user
     */
    fun dialogVisible(tag: String, rule: ActivityTestRule<*>) {
        rule.activity.runOnUiThread {
            val resumedActivity = ActivityLifecycleMonitorRegistry.getInstance()
                .getActivitiesInStage(Stage.RESUMED)

            val activity = resumedActivity.first() as AppCompatActivity
            val visible = activity.supportFragmentManager.findFragmentByTag(tag)!!.isVisible

            Assert.assertTrue(visible)
        }
    }
}
