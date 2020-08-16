package br.com.odete.commonstest.test

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import androidx.test.runner.lifecycle.Stage

class FragmentIdlingResource(private var tag: String) : IdlingResource {

    private lateinit var resourceCallback: IdlingResource.ResourceCallback
    private var isIdle: Boolean = false

    override fun getName(): String {
        return FragmentIdlingResource::class.java.name
    }

    override fun isIdleNow(): Boolean {

        if (isIdle) return true

        val activity = getCurrentActivity()
        val findFragmentById = activity.supportFragmentManager.findFragmentByTag(tag)
        findFragmentById?.let { isIdle = isIdle(it) }
        if (isIdle) {
            resourceCallback.onTransitionToIdle()
        }
        return isIdle
    }

    override fun registerIdleTransitionCallback(callback: IdlingResource.ResourceCallback) {
        resourceCallback = callback
    }

    private fun isIdle(findFragmentById: Fragment): Boolean {
        return findFragmentById.isResumed &&
            findFragmentById.isAdded &&
            findFragmentById.view != null
    }

    private fun getCurrentActivity(): AppCompatActivity {
        val resumedActivity =
            ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED)
        return resumedActivity.first() as AppCompatActivity
    }
}

fun FragmentIdlingResource.register() {
    IdlingRegistry.getInstance().register(this)
}

fun FragmentIdlingResource.unRegister() {
    IdlingRegistry.getInstance().unregister(this)
}
