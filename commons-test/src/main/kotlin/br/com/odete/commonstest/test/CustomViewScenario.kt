package br.com.odete.commonstest.test

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider.getApplicationContext

class CustomViewScenario<V : View> private constructor(
    private val customView: V,
    private val activityScenario: ActivityScenario<FragmentTestActivity>,
    private val setupCustomView: (() -> Unit)? = null
) {

    companion object {

        fun <V : View> launchCustomView(resourceId: Int): CustomViewScenario<in V> {
            val view =
                LayoutInflater.from(getApplicationContext()).inflate(resourceId, null)

            return internalLaunch(view)
        }

        fun <V : View> launchCustomView(customView: V, function: (() -> Unit)? = null) =
            internalLaunch(customView, function)

        private fun <V : View> internalLaunch(
            customView: V,
            function: (() -> Unit)? = null
        ): CustomViewScenario<V> {

            val emptyActivityIntent =
                Intent(getApplicationContext(), FragmentTestActivity::class.java)

            return CustomViewScenario(
                customView,
                ActivityScenario.launch(emptyActivityIntent),
                function
            )
        }
    }

    fun runOnUIThread(execute: () -> Unit) {
        activityScenario.onActivity {
            execute()
        }
    }

    init {
        activityScenario.onActivity {
            val frameLayout = it.findViewById<FrameLayout>(android.R.id.content)

            frameLayout.addView(customView)

            setupCustomView?.invoke()
        }
    }
}
