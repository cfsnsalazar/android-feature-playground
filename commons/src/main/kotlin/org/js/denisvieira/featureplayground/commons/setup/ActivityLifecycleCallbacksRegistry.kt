package org.js.denisvieira.featureplayground.commons.setup

import android.app.Application
import org.js.denisvieira.libraries.events.app.OnCreateAppListener
import java.lang.ref.WeakReference

internal class ActivityLifecycleCallbacksRegistry(
    private val callbacks: Set<Application.ActivityLifecycleCallbacks>,
    app: Application
) : OnCreateAppListener {

    private val app = WeakReference(app)

    override fun run() {
        app.get()?.apply {
            callbacks.forEach(::registerActivityLifecycleCallbacks)
        }
    }
}
