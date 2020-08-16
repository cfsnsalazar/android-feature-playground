package org.js.denisvieira.libraries.events.app

/**
 * This interface represents the contract to run some code on Android application creation.
 * The implementation should be declared in feature's DI module
 *
 * Example using Kodein:
 *
 * <code>
 *     bind<OnCreateAppListener>().inSet() with provider {
 *          MyOnCreateAppListener()
 *     }
 * </code>
 */
interface OnCreateAppListener {

    /**
     * Will be executed in [android.app.Application::onCreate]
     * @see [OnCreateApp]
     */
    fun run()
}
