package org.js.denisvieira.featureplayground.commons.cache

import android.app.Application
import org.js.denisvieira.libraries.events.app.OnCreateAppListener
import java.lang.ref.WeakReference

internal class CacheConfigurator(
    private val cacheManager: CacheManager,
    app: Application
) : OnCreateAppListener {

    private val app = WeakReference(app)

    override fun run() {
        app.get()?.let { cacheManager.init(it) }
    }
}
