package org.js.denisvieira.featureplayground.commons.setup

import android.app.Application
import android.app.Application.ActivityLifecycleCallbacks
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.hamcrest.Matchers.contains
import org.junit.Assert.assertThat
import org.junit.Test

class ActivityLifecycleCallbacksRegistryTest {

    private val application = mock<Application>()

    private val activityLifecycleCallbacksA = mock<ActivityLifecycleCallbacks>()
    private val activityLifecycleCallbacksB = mock<ActivityLifecycleCallbacks>()

    private val target = ActivityLifecycleCallbacksRegistry(
        setOf(activityLifecycleCallbacksA, activityLifecycleCallbacksB),
        application
    )

    @Test
    fun whenRun_shouldRegisterActivityLifecycleCallbacks() {
        val argumentCaptor = argumentCaptor<ActivityLifecycleCallbacks>()

        target.run()

        verify(application, times(2))
            .registerActivityLifecycleCallbacks(argumentCaptor.capture())
        assertThat(
            argumentCaptor.allValues,
            contains(activityLifecycleCallbacksA, activityLifecycleCallbacksB)
        )
    }
}
