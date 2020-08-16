package com.odete.router

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

val routerModule = Kodein.Module("routerModule") {

    bind() from singleton {
        IntentUtils()
    }
}
