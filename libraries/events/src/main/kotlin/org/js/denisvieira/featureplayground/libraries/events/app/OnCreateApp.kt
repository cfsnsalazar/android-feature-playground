package org.js.denisvieira.libraries.events.app

/**
 * Class to decouple the configuration between the modules and the application.
 * With this, the *app/main* module don't need to know what is necessary to this setup,
 * giving this responsibility only to *feature module*.
 *
 * @see [OnCreateAppListener]
 */
class OnCreateApp(
    private val listeners: Set<OnCreateAppListener>
) {

    /**
     * Run all [listeners]
     *
     * This method should be called in [android.app.Application::onCreate]
     */
    fun execute() {
        listeners.forEach { it.run() }
    }
}
