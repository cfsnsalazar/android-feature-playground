package com.odete.library.di

import android.app.Application
import android.content.Context
import org.js.denisvieira.featureplayground.commons.di.commonsModule
import com.odete.router.routerModule
import org.kodein.di.Kodein
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import java.lang.ref.WeakReference

fun appModule(application: Application) = Kodein.Module("appModule") {
    import(androidXModule(application))
    bind() from singleton { instance<Context>().resources }
    bind() from provider { WeakReference(instance<Context>()) }
    import(commonsModule)
    import(routerModule)
}
