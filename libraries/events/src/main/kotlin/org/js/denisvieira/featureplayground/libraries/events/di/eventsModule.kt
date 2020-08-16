package org.js.denisvieira.featureplayground.libraries.events.di

import org.js.denisvieira.libraries.events.app.OnCreateApp
import org.js.denisvieira.libraries.events.app.OnCreateAppListener
import org.js.denisvieira.libraries.events.login.OnLogoutEvent
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.setBinding

val eventsModule = Kodein.Module("eventsModule") {

    bind() from setBinding<OnCreateAppListener>()

    bind() from setBinding<OnLogoutEvent>()

    bind() from provider {
        OnCreateApp(instance())
    }
}
